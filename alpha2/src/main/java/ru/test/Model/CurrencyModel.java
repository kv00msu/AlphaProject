package ru.test.Model;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyModel {
    private String disclaimer;
    private String license;
    private String timestamp;
    private String base;
    private Map<String,Float> rates;

}
