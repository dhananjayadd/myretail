package com.myretail.myretail.entity;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transactions {
    private int id;
    private int customerID;
    private String itemName;
    private int price;
    private LocalDate transactionDate;

}
