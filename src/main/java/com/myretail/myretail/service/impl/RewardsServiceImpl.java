package com.myretail.myretail.service.impl;

import com.myretail.myretail.entity.MonthlyRewars;
import com.myretail.myretail.entity.RewardsByCustAndTrans;
import com.myretail.myretail.entity.TotalRewards;
import com.myretail.myretail.entity.Transactions;
import com.myretail.myretail.exceptions.CustomerNotFoundException;
import com.myretail.myretail.service.RewardsService;
import com.myretail.myretail.utility.TransactionsUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RewardsServiceImpl implements RewardsService {

    @Override
    public TotalRewards getTotalRewardsByCustomer(int customerID) {
        List<Transactions> transByCust = TransactionsUtility.getTransactions(customerID);
        if(transByCust==null || transByCust.size()==0)
            throw new CustomerNotFoundException(customerID);
        List<RewardsByCustAndTrans> rewardsByCust = TransactionsUtility.getRewardsByTrans(transByCust);
        int totalRewardsPoints = rewardsByCust.stream().map(RewardsByCustAndTrans::getRewardPoints).reduce(0,Integer::sum);
        RewardsByCustAndTrans firstCust = rewardsByCust.get(0);
        TotalRewards totalRewards = new TotalRewards();
        totalRewards.setCustomerID(firstCust.getCustomerID());
        totalRewards.setTotalRewards(totalRewardsPoints);

        return totalRewards;
    }

    @Override
    public List<MonthlyRewars> getMonthlyRewardsByCustomer(int customerID) {
        List<Transactions> transByCust = TransactionsUtility.getTransactions(customerID);
        if(transByCust==null || transByCust.size()==0)
            throw new CustomerNotFoundException(customerID);
        List<RewardsByCustAndTrans> rewardsByCust = TransactionsUtility.getRewardsByTrans(transByCust);
        //group transactions by month
        Map<Month, List<RewardsByCustAndTrans>> transByMonth = rewardsByCust.stream()
                                .collect(Collectors.groupingBy(trans -> trans.getTransDate().getMonth()));
        List<MonthlyRewars> monthlyRewards = new ArrayList<>();
        transByMonth.forEach((month, translist)->{
            int totalRewardsPoints = translist.stream().map(RewardsByCustAndTrans::getRewardPoints).reduce(0,Integer::sum);
            monthlyRewards.add(new MonthlyRewars(translist.get(0).getCustomerID(),
                                totalRewardsPoints,translist.get(0).getTransDate().getMonthValue(),
                                    translist.get(0).getTransDate().getYear()));
        });
        return monthlyRewards;
    }
}
