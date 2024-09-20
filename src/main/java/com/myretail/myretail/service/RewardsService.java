package com.myretail.myretail.service;

import com.myretail.myretail.entity.MonthlyRewars;
import com.myretail.myretail.entity.TotalRewards;

import java.util.List;

public interface RewardsService {

    public TotalRewards getTotalRewardsByCustomer(int customerID);

    public List<MonthlyRewars> getMonthlyRewardsByCustomer(int customerID);
}
