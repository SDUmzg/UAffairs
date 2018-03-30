package com.alearner.service;

import com.alearner.orm.HomeTargetMapper;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.alearner.orm.HomeTarget;
import com.alearner.orm.UserDto;
import com.alearner.orm.UserRowMapper;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private HbaseTemplate hbaseTemplate;

    public List<UserDto> query(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<UserDto> dtos = this.hbaseTemplate.find("user", scan, new UserRowMapper());
        return dtos;
    }

    public UserDto query(String row) {
        UserDto dto = this.hbaseTemplate.get("user", row, new UserRowMapper());
        return dto;
    }

    public HomeTarget queryHome(String table,String row,String family) {


        HomeTarget dto = this.hbaseTemplate.get(table, row, new HomeTargetMapper());
        return dto;
    }
}