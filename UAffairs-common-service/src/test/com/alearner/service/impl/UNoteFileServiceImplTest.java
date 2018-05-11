package com.alearner.service.impl;

import com.alearner.modle.mysql.UNoteFile;
import com.alearner.service.UNoteFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 10:53
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UNoteFileServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNoteFileService uNoteFileService;

    @Test
    public void addUNoteFile() {
        UNoteFile uNoteFile =  new UNoteFile();
        uNoteFile.setName("u-note-file-name");
        uNoteFile.setType("note");
        uNoteFile.setSubject("test service");
        uNoteFile.setStoreTool(0);
        uNoteFile.setStoreId(0);
        long id = uNoteFileService.addUNoteFile(uNoteFile);
        System.err.println(id);
    }

    @Test
    public void getUNoteFileById() {
        UNoteFile uNoteFile = uNoteFileService.getUNoteFileById(1);
        System.err.println(uNoteFile.toString());
    }
}