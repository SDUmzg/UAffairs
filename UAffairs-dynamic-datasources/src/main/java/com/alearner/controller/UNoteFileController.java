package com.alearner.controller;

import com.alearner.entity.mysql.UNoteFile;
import com.alearner.service.UNoteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 09:20
 **/
@RestController
@RequestMapping(value = "u-note-file")
public class UNoteFileController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNoteFileService uNoteFileService;


    @RequestMapping(value = "/addUNoteFile",method = RequestMethod.POST)
    public long addUNoteFile(@RequestBody UNoteFile uNoteFile){
        logger.info("访问Controller层 ：UNoteFileController   方法 ： addUNoteFile  ， fileName  :  "+ uNoteFile.getName());
        uNoteFileService.addUNoteFile(uNoteFile);
        //返回主键
        return uNoteFile.getId();
    }
    public UNoteFile getUNoteFileById(@RequestParam("id") int id){
        logger.info("访问Controller层 ：UNoteFileController   方法 ： getUNoteFileById  ， id  :  "+  id);
        return uNoteFileService.getUNoteFileById(id);
    }
}
