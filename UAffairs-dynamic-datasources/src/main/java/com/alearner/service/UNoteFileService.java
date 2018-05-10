package com.alearner.service;

import com.alearner.entity.mysql.UNoteFile;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:54
 **/
public interface UNoteFileService {
    long addUNoteFile(UNoteFile uNoteFile);
    UNoteFile getUNoteFileById(int id);
}
