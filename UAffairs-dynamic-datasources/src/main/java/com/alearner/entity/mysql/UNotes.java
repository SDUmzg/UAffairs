package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:07
 **/
@Getter
@Setter
public class UNotes extends BaseModel{
    private int id;
    private String subject;
    private String content;
    private int ownerId;
    private int ownerType;
}
