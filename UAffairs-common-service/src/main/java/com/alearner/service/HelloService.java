package com.alearner.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.alearner.modle.hbase.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name){
        return restTemplate.getForObject("http://hbase-client/hello?name="+name,String.class);
    }

    public UserDto queryHbase(String row){
        UserDto userDto=restTemplate.getForObject("http://hbase-client/queryHbase?row="+row,UserDto.class);
        return userDto;
    }


    public List<UserDto> query(String startRow,
                               String stopRow){
        String url = "http://hbase-client/query?startRow="+startRow+"&stopRow="+stopRow;
        return restTemplate.getForObject(url,List.class);
    }


    public String helloError(String name){
        return "hi , "+name+"  orror request ,service name : ribbon";
    }




}
