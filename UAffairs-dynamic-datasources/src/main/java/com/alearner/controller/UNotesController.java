package com.alearner.controller;

import com.alearner.entity.mysql.UNotes;
import com.alearner.service.UNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 09:49
 **/
@RestController
@RequestMapping(value = "/u-notes")
public class UNotesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotesService uNotesService;

    @RequestMapping(value = "/addUNotes" , method = RequestMethod.POST)
    public long addUNotes(@RequestBody UNotes uNotes){
        logger.info("访问Controller层 ：UNotesController   方法 ： addUNotes  ， UNotes  :  "+ uNotes.toString());
        return uNotesService.addUNotes(uNotes);
    }

    @RequestMapping(value = "/getUNotesById" , method = RequestMethod.GET)
    public UNotes getUNotesById(@RequestParam("id") int id){
        logger.info("访问Controller层 ：UNotesController   方法 ： getUNotesById  ， id  :  "+ id);
        return uNotesService.getUNotesById(id);
    }
}
