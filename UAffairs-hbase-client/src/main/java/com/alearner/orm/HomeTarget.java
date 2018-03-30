package com.alearner.orm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HomeTarget {
    private String active_monVal;
    private String active_lastDayVal;
    private String active_weekPercent;
    private String active_dayPercent;

    private String income_monVal;
    private String income_lastDayVal;
    private String income_weekPercent;
    private String income_dayPercent;

    private String new_monVal;
    private String new_lastDayVal;
    private String new_weekPercent;
    private String new_dayPercent;

    private String total_monVal;
    private String total_lastDayVal;
    private String total_weekPercent;
    private String total_dayPercent;
}
