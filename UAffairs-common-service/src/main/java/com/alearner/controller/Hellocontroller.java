package com.alearner.controller;

import com.alearner.modle.common.HelloModel;
import com.alearner.modle.hbase.UserDto;
import com.alearner.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Hellocontroller {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return helloService.hello(name);
    }


    @RequestMapping(value = "/helloModelJson",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloModel helloModelJson(){
        HelloModel helloModel=new HelloModel();
        helloModel.setName("ma");
        helloModel.setSex("man");
        return helloModel;
    }

    @RequestMapping(value = "/helloModelXml",method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    public HelloModel helloModelXml(){
        HelloModel helloModel=new HelloModel();
        helloModel.setName("ma");
        helloModel.setSex("man");
        return helloModel;
    }

    @RequestMapping(value = "/queryHbase",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto queryHbase(@RequestParam(value = "row") String row){
        return helloService.queryHbase(row);
    }


}
