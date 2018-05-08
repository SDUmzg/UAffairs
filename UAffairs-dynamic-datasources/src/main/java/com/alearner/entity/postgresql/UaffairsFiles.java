package com.alearner.entity.postgresql;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-08 17:17
 **/
@Getter
@Setter
public class UaffairsFiles {
    private int id;
    private String fileName;
    private byte[] content;
    private String operateTime;
}
