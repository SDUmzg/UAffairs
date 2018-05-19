package com.alearner.service.impl;

import com.alearner.modle.mysql.UNotes;
import com.alearner.service.UNotesService;
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
 * @create: 2018-05-11 11:11
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UNotesServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UNotesService uNotesService;

    @Test
    public void addUNotes() {
        UNotes uNotes = new UNotes();
        uNotes.setSubject("毕业前的作业");
        uNotes.setContent("作业作业作业作业作业作业");
       long id = uNotesService.addUNotes(uNotes);
        System.err.println(id);
    }

    @Test
    public void getUNotesById() {
        UNotes uNotes=uNotesService.getUNotesById(1);
        System.err.println(uNotes.toString());
    }
}