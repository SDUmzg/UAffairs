package com.alearner.modle.common;

import com.alearner.modle.mysql.UFamilyRelation;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.mysql.UStudent;
import com.alearner.modle.mysql.UTeacher;
import lombok.*;

import java.util.List;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 12:16
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInformation {
    private int ssoId;
    private int eduId;
    private int eduType;
    private String uId;//学号或者工号
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String idCard;
    private int superiorId;
    private int role;
    private int status;
    private List<UFamilyRelation> uFamilyRelationList;

    public UserInformation(USsoUserEdu uSsoUserEdu, UTeacher uTeacher, UStudent uStudent,List<UFamilyRelation> uFamilyRelationList){
        this.ssoId=uSsoUserEdu.getSsoId();
        this.eduId=uSsoUserEdu.getEduId();
        this.eduType=uSsoUserEdu.getEduType();

        if (uFamilyRelationList!=null){
            this.uFamilyRelationList=uFamilyRelationList;
        }
        if (uTeacher!=null){
            this.uId=uTeacher.getUId();
            this.name=uTeacher.getName();
            this.sex=uTeacher.getSex();
            this.phone=uTeacher.getPhone();
            this.email=uTeacher.getEmail();
            this.idCard=uTeacher.getIdCard();
            this.superiorId=uTeacher.getCollegeId();
            this.role=uTeacher.getRole();
            this.status=uTeacher.getStatus();
        }else if (uStudent!=null){
            this.uId=uStudent.getUId();
            this.name=uStudent.getName();
            this.sex=uStudent.getSex();
            this.phone=uStudent.getPhone();
            this.email=uStudent.getEmail();
            this.idCard=uStudent.getIdCard();
            this.superiorId=uStudent.getClassesId();
            this.role=uStudent.getRole();
            this.status=uStudent.getStatus();
        }
    }

}
