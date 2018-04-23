package com.alearner.entity.postgresql;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Users {
    private int id;
    private String userid;
    private String psw;
    private String email;
    private String name;

}
