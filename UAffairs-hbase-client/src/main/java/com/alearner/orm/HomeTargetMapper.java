package com.alearner.orm;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class HomeTargetMapper implements RowMapper<HomeTarget>{
    private static byte[] COLUMNFAMILY1 = "active".getBytes();
    private static byte[] F11 = "f1".getBytes();
    private static byte[] F12 = "f2".getBytes();
    private static byte[] F13 = "f3".getBytes();
    private static byte[] F14 = "f4".getBytes();
    private static byte[] COLUMNFAMILY2 = "income".getBytes();
    private static byte[] F21 = "f1".getBytes();
    private static byte[] F22 = "f2".getBytes();
    private static byte[] F23 = "f3".getBytes();
    private static byte[] F24 = "f4".getBytes();
    private static byte[] COLUMNFAMILY3 = "new".getBytes();
    private static byte[] F31 = "f1".getBytes();
    private static byte[] F32 = "f2".getBytes();
    private static byte[] F33 = "f3".getBytes();
    private static byte[] F34 = "f4".getBytes();
    private static byte[] COLUMNFAMILY4 = "total".getBytes();
    private static byte[] F41 = "f1".getBytes();
    private static byte[] F42 = "f2".getBytes();
    private static byte[] F43 = "f3".getBytes();
    private static byte[] F44 = "f4".getBytes();


//    @Override
//    public HomeTargetList mapRow(Result result, int i) throws Exception {
//        HomeTarget2 ht=new HomeTarget2();
//        String monVal = Bytes.toString(result.getValue(COLUMNFAMILY1, F11));
//        String lastDayVal = Bytes.toString(result.getValue(COLUMNFAMILY1, F12));
//        String weekPercent = Bytes.toString(result.getValue(COLUMNFAMILY1, F13));
//        String dayPercent = Bytes.toString(result.getValue(COLUMNFAMILY1, F14));
//        HomeTargetList lht = new HomeTargetList();
//        ht.setName("新增用户");
//        ht.setMonVal(monVal);
//        ht.setLastDayVal(lastDayVal);
//        ht.setWeekPercent(weekPercent);
//        ht.setDayPercent(dayPercent);
//        lht.add(ht);
//        return lht;
//    }

    @Override
    public HomeTarget mapRow(Result result, int i) throws Exception {
        HomeTarget ht=new HomeTarget();
        String monVal = Bytes.toString(result.getValue(COLUMNFAMILY1, F11));
        String lastDayVal = Bytes.toString(result.getValue(COLUMNFAMILY1, F12));
        String weekPercent = Bytes.toString(result.getValue(COLUMNFAMILY1, F13));
        String dayPercent = Bytes.toString(result.getValue(COLUMNFAMILY1, F14));
        ht.setActive_monVal(monVal);
        ht.setActive_lastDayVal(lastDayVal);
        ht.setActive_weekPercent(weekPercent);
        ht.setActive_dayPercent(dayPercent);


        String monVal2 = Bytes.toString(result.getValue(COLUMNFAMILY2, F21));
        String lastDayVal2 = Bytes.toString(result.getValue(COLUMNFAMILY2, F22));
        String weekPercent2 = Bytes.toString(result.getValue(COLUMNFAMILY2, F23));
        String dayPercent2 = Bytes.toString(result.getValue(COLUMNFAMILY2, F24));

        ht.setIncome_monVal(monVal2);
        ht.setIncome_lastDayVal(lastDayVal2);
        ht.setIncome_weekPercent(weekPercent2);
        ht.setIncome_dayPercent(dayPercent2);

        String monVal3 = Bytes.toString(result.getValue(COLUMNFAMILY3, F31));
        String lastDayVal3 = Bytes.toString(result.getValue(COLUMNFAMILY3, F32));
        String weekPercent3 = Bytes.toString(result.getValue(COLUMNFAMILY3, F33));
        String dayPercent3 = Bytes.toString(result.getValue(COLUMNFAMILY3, F34));

        ht.setNew_monVal(monVal3);
        ht.setNew_lastDayVal(lastDayVal3);
        ht.setNew_weekPercent(weekPercent3);
        ht.setNew_dayPercent(dayPercent3);

        String monVal4 = Bytes.toString(result.getValue(COLUMNFAMILY4, F41));
        String lastDayVal4 = Bytes.toString(result.getValue(COLUMNFAMILY4, F42));
        String weekPercent4 = Bytes.toString(result.getValue(COLUMNFAMILY4, F43));
        String dayPercent4 = Bytes.toString(result.getValue(COLUMNFAMILY4, F44));

        ht.setTotal_monVal(monVal4);
        ht.setTotal_lastDayVal(lastDayVal4);
        ht.setTotal_weekPercent(weekPercent4);
        ht.setTotal_dayPercent(dayPercent4);
        return ht;
    }
}
