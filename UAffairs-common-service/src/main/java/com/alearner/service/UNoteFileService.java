package com.alearner.service;

import com.alearner.modle.mysql.UNoteFile;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 10:16
 **/
public interface UNoteFileService {
    long addUNoteFile(UNoteFile uNoteFile);
    UNoteFile getUNoteFileById(int id);
}
