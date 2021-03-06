package com.alearner.service.impl;

import com.alearner.entity.postgresql.UaffairsFiles;
import com.alearner.service.UaffairsFilesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @description:
 * @author: MZG
 * @create: 2018-05-08 18:23
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UaffairsFilesServiceImplTest {

    @Autowired
    private UaffairsFilesService uaffairsFilesService;

    @Test
    public void addUaffairsFilesMapper() throws IOException {
        String filePath = "/Users/mazongguang/Development/IdeaProjects/UAffairs/sql/uaffairs20180420.sql";
        Path path = Paths.get(filePath);
        byte[] data = Files.readAllBytes(path);
        String fileName = path.getFileName().toString();
        System.err.println(fileName);
        UaffairsFiles uaffairsFiles=new UaffairsFiles();
        uaffairsFiles.setFileName(fileName);
        uaffairsFiles.setContent(data);

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date  = dateFormat.format(new Date());


//        Date date = new Date();
//        Timestamp time = new Timestamp(date.getTime());


////        System.out.println(time.toString());
//        uaffairsFiles.setOperateTime(date);

        long row = uaffairsFilesService.addUaffairsFiles(uaffairsFiles);
        System.out.println(row);
        System.err.println(uaffairsFiles.getId());
    }

    @Test
    public void getUaffairsFilesById() {
        UaffairsFiles uaffairsFiles = uaffairsFilesService.getUaffairsFilesById(1);
        System.err.println(uaffairsFiles.getFileName());
        System.err.println(uaffairsFiles.getOperateTime());
    }
}