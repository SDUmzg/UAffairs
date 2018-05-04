package com.alearner.controller;

import com.alearner.entity.mysql.UFamilyRelation;
import com.alearner.service.UFamilyRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 10:00
 **/
@RestController
@RequestMapping(value = "/family-relation")
public class UFamilyRelationController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UFamilyRelationService uFamilyRelationService;

    @RequestMapping(value = "/getUFamilyRelationByStuId",method = RequestMethod.GET)
    public List<UFamilyRelation> getUFamilyRelationByStuId(@RequestParam(value = "stu_id") int stu_id){
        logger.info("访问controller层，方法 ：getUFamilyRelationByStuId  ，Param ： -  "+stu_id);
        return uFamilyRelationService.getUFamilyRelationByStuId(stu_id);
    }
}
