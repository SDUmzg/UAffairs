package com.alearner.service;

import com.alearner.modle.common.UserInformation;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-04 14:29
 **/
public interface UserInformationService {
    UserInformation getUserInformationBySsoId(int sso_id);
}
