package com.alearner.controller;

import com.alearner.orm.HomeTarget;
import com.alearner.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @Autowired
    QueryService queryService;



    @RequestMapping(value = "/home/getTarget",method = RequestMethod.GET,produces = "application/json")
    public HomeTarget queryTarget(@RequestParam(value = "row") String row,
                                        @RequestParam(value = "table") String table){
        return queryService.queryHome(table,row,"active");
    }


//    @RequestMapping(value = "/home/getTarget",method = RequestMethod.GET,produces = "application/json")
//    public List<HomeTarget> queryTarget(@RequestParam(value = "row") String row,
//                                        @RequestParam(value = "table") String table){
//        List<HomeTarget> hto = new ArrayList<HomeTarget>();
//        HomeTarget ht = new HomeTarget();
//        ht = queryService.queryHome(table,row,"active");
//        hto.add(ht);
//        return hto;
//    }


}