package com.alearner.entity.mysql;

import com.alearner.entity.common.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-03 19:07
 **/
@Getter
@Setter
public class USsoUserEdu extends BaseModel{
    private int ssoId;
    private int eduId;
    private int eduType;
}
