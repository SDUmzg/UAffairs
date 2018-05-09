package com.alearner.controller;

import com.alearner.entity.postgresql.UaffairsFiles;
import com.alearner.service.UaffairsFilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-09 14:27
 **/
@RequestMapping(value = "/fileUpload")
public class UaffairsFilesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UaffairsFilesService uaffairsFilesService;


    @PostMapping(value = "/addUaffairsFiles")
    public long addUaffairsFiles(@RequestBody UaffairsFiles uaffairsFiles){
        logger.info("采用Controller层 ： UaffairsFilesController 方法 ：addUaffairsFiles");
        logger.info("文件名称，name :" + uaffairsFiles.getFileName());
        return uaffairsFilesService.addUaffairsFiles(uaffairsFiles);
    }

    @GetMapping(value = "/getUaffairsFilesById")
    public UaffairsFiles getUaffairsFilesById(@RequestParam(value = "id")int id){
        logger.info("采用Controller层 ： UaffairsFilesController 方法 ：getUaffairsFilesById");
        logger.info("请求id ：" + id);
        return uaffairsFilesService.getUaffairsFilesById(id);
    }

}
