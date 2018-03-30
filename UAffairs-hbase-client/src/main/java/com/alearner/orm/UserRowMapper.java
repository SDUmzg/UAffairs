package com.alearner.orm;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class UserRowMapper implements RowMapper<UserDto>{
    private static byte[] COLUMNFAMILY = "f".getBytes();
    private static byte[] NAME = "name".getBytes();
    private static byte[] SEX = "sex".getBytes();

    @Override
    public UserDto mapRow(Result result, int i) throws Exception {
        UserDto dto=new UserDto();
        String name = Bytes.toString(result.getValue(COLUMNFAMILY, NAME));
        String sex = Bytes.toString(result.getValue(COLUMNFAMILY, SEX));

        dto.setName(name);
        dto.setSex(sex);
        return dto;
    }
}
