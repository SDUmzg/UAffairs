package com.alearner.controller;

import com.alearner.entity.mysql.UFamilyRelation;
import com.alearner.service.UFamilyRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addUFamilyRelation",method = RequestMethod.GET)
    public long addUFamilyRelation(@RequestParam(value = "stuId") String stuId,
                                   @RequestParam(value = "name")String name,
                                   @RequestParam(value = "phone")String phone,
                                   @RequestParam(value = "email")String email,
                                   @RequestParam(value = "relation") String relation){
        UFamilyRelation uFamilyRelation = new UFamilyRelation();
        uFamilyRelation.setStuId(stuId);
        uFamilyRelation.setName(name);
        uFamilyRelation.setPhone(phone);
        uFamilyRelation.setEmail(email);
        uFamilyRelation.setRelation(relation);
        logger.info("访问controller层，方法 ：addUFamilyRelation  ，Param ： -  "+uFamilyRelation.toString());
        uFamilyRelationService.addUFamilyRelation(uFamilyRelation);
        return uFamilyRelation.getId();
    }

    @RequestMapping(value = "/updateFamilyRelationList",method = RequestMethod.POST)
    public long updateFamilyRelationList(@RequestBody List<UFamilyRelation> uFamilyRelationList){
        logger.info("访问controller层，方法 ：updateFamilyRelationList  ，Param ：uFamilyRelationList.size -  "+uFamilyRelationList.size());
        return uFamilyRelationService.updateFamilyRelationList(uFamilyRelationList);
    }

}
