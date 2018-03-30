package com.alearner.controller;

import com.alearner.orm.UserDto;
import com.alearner.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {


    @Autowired
    QueryService queryService;

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hello")
    public String home(@RequestParam(value = "name")String name){
        return "hello use hbase client : "+name+"  ,I am from port : "+port;
    }

    @ResponseBody
    @RequestMapping(value = "/queryHbase",method = RequestMethod.GET)
    public UserDto queryHbase(@RequestParam(value = "row") String row){
        return queryService.query(row);
    }


    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public List<UserDto> query(@RequestParam(value = "startRow")String startRow,
                               @RequestParam(value = "stopRow")String stopRow){
        return queryService.query(startRow,stopRow);
    }

}