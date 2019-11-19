package com.imooc.StreamTest;

import lombok.Data;
import lombok.ToString;

/**
 * @author : Fy
 * @date : 2018-04-23 14:38
 */
@Data
@ToString
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
