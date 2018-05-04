package com.alearner.modle.mysql;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-04-04 18:35
 **/

@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private String sex;
    private String grand;
    private String phone;
}
