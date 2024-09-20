package com.myretail.myretail.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RewardsByCustAndTrans {
    private int transID;
    private int customerID;
    private int rewardPoints;
    private LocalDate transDate;
}
