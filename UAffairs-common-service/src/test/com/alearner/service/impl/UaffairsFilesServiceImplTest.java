package com.alearner.service.impl;

import com.alearner.modle.postgresql.UaffairsFiles;
import com.alearner.service.UaffairsFilesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/**
 * @description:
 * @author: MZG
 * @create: 2018-05-09 15:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UaffairsFilesServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UaffairsFilesService uaffairsFilesService;

    @Test
    public void addUaffairsFilesMapper() throws IOException {
        String filePath = "/Users/mazongguang/Development/IdeaProjects/UAffairs/sql/postgresql.sql";
        Path path = Paths.get(filePath);
        byte[] data = Files.readAllBytes(path);
        String fileName = path.getFileName().toString();
        System.err.println(fileName);
        UaffairsFiles uaffairsFiles=new UaffairsFiles();
        uaffairsFiles.setFileName(fileName);
        uaffairsFiles.setContent(data);


        long row = uaffairsFilesService.addUaffairsFiles(uaffairsFiles);
        System.out.println(row);
        System.err.println(uaffairsFiles.getId());


        /*

        Timestamp d = new Timestamp(System.currentTimeMillis());

        Date date = new Date();
        Timestamp nousedate = new Timestamp(date.getTime());


        * */
    }

    @Test
    public void getUaffairsFilesById() {
        UaffairsFiles uaffairsFiles=uaffairsFilesService.getUaffairsFilesById(1);
        System.err.println(uaffairsFiles.getFileName());
        System.err.println(uaffairsFiles.getOperateTime());
    }
}