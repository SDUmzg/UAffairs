package com.alearner.service;


import com.alearner.modle.mysql.UNotes;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:57
 **/
public interface UNotesService {
    long addUNotes(UNotes uNotes);
    UNotes getUNotesById(int id);
}
