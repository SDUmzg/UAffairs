package com.alearner.modle.mysql;


import com.alearner.modle.common.BaseModel;
import lombok.*;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-22 08:04
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UUserNotify extends BaseModel {
    private int id;
    private boolean readStatus;
    private int userId;
    private int notifyId;
}
