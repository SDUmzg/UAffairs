package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:04
 **/
@Setter
@Getter
@ToString
public class UNoteFile extends BaseModel {
    private int id;
    private String name;
    private String type;
    private String subject;
    private int ownerId;
    private int ownerType;
    private int storeTool;
    private int storeId;
}
