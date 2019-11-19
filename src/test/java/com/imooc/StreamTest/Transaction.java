package com.imooc.StreamTest;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

}