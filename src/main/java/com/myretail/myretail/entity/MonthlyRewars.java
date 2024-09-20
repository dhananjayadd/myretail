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
public class MonthlyRewars {
    private int customerID;
    private int monthlyRewards;
    private int month;
    private int year;
}
