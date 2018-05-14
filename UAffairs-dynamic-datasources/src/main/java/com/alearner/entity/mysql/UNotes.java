package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-10 18:07
 **/
@Getter
@Setter
@ToString
public class UNotes extends BaseModel{
    private int id;
    private String subject;
    private String content;
}
