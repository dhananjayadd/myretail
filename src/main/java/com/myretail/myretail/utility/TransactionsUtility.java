package com.myretail.myretail.utility;

import com.myretail.myretail.entity.RewardsByCustAndTrans;
import com.myretail.myretail.entity.Transactions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionsUtility {
    private static List<Transactions> listTrans = new ArrayList<>();

    static {
        listTrans.add(new Transactions(1,111,"pen",100, LocalDate.of(2024,7,01)));
        listTrans.add(new Transactions(2,111,"ink",130, LocalDate.of(2024,7,02)));
        listTrans.add(new Transactions(3,111,"paper",80, LocalDate.of(2024,7,15)));
        listTrans.add(new Transactions(4,222,"cool drink",120, LocalDate.of(2024,7,05)));
        listTrans.add(new Transactions(5,333,"chips",60, LocalDate.of(2024,7,07)));
        listTrans.add(new Transactions(6,333,"jam",110, LocalDate.of(2024,7,18)));

        listTrans.add(new Transactions(7,111,"pen",100, LocalDate.of(2024,8,14)));
        listTrans.add(new Transactions(8,222,"paper",80, LocalDate.of(2024,8,18)));
        listTrans.add(new Transactions(9,222,"cool drink",120, LocalDate.of(2024,8,10)));
        listTrans.add(new Transactions(10,333,"chips",60, LocalDate.of(2024,8,11)));
        listTrans.add(new Transactions(11,333,"jam",110, LocalDate.of(2024,8,3)));
        listTrans.add(new Transactions(12,333,"ink",130, LocalDate.of(2024,8,13)));

        listTrans.add(new Transactions(13,111,"pen",100, LocalDate.of(2024,9,4)));
        listTrans.add(new Transactions(14,111,"ink",130, LocalDate.of(2024,9,5)));
        listTrans.add(new Transactions(15,222,"paper",80, LocalDate.of(2024,9,6)));
        listTrans.add(new Transactions(16,222,"cool drink",120, LocalDate.of(2024,9,7)));
        listTrans.add(new Transactions(17,222,"chips",60, LocalDate.of(2024,9,8)));
        listTrans.add(new Transactions(18,333,"jam",110, LocalDate.of(2024,9,9)));
    }

    /**
     * return transactions based on customer id
     * **/
    public static List<Transactions> getTransactions(int customerID){

        return listTrans.stream().
                filter(transactions -> transactions.getCustomerID()==customerID).
                collect(Collectors.toList());
    }

    public static List<RewardsByCustAndTrans> getRewardsByTrans(List<Transactions> transByCust){
        List<RewardsByCustAndTrans> rewadrsByTrans = new ArrayList<>();
        for(Transactions t:transByCust){
            int rewardPoints = 0;
            if(t.getPrice()>100){
                rewardPoints = ((t.getPrice() - 100)*2) + 50;
            }else
                if(t.getPrice() > 50 && t.getPrice() <=100){
                    rewardPoints = (t.getPrice()-50);
                }
            rewadrsByTrans.add(new RewardsByCustAndTrans(t.getId(),t.getCustomerID(),rewardPoints,t.getTransactionDate()));
        }
        return rewadrsByTrans;
    }
}
