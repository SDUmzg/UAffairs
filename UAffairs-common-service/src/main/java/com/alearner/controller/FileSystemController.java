package com.alearner.controller;

import com.alearner.modle.common.ReturnT;
import com.alearner.modle.mysql.UNoteFile;
import com.alearner.modle.mysql.USsoUserEdu;
import com.alearner.modle.postgresql.UaffairsFiles;
import com.alearner.service.UNoteFileService;
import com.alearner.service.UNotesService;
import com.alearner.service.UaffairsFilesService;
import com.alearner.service.UserInformationService;
import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.user.XxlUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * @description:
 * @author: MZG
 * @create: 2018-05-11 14:56
 **/
@RestController
@RequestMapping(value = "/file-system")
@CrossOrigin
public class FileSystemController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UaffairsFilesService uaffairsFilesService;
    @Autowired
    private UNoteFileService uNoteFileService;
    @Autowired
    private UNotesService uNotesService;
    @Autowired
    private UserInformationService userInformationService;


    @RequestMapping(value = "/singleFileUpload",method = RequestMethod.GET)
    public ReturnT<String> singleFileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file,
                                    @RequestParam("subject")String subject){
        logger.debug("上传文件");
        XxlUser xxlUser = (XxlUser) request.getAttribute(Conf.SSO_USER);
        USsoUserEdu uSsoUserEdu = userInformationService.getUSsoUserEduById(xxlUser.getUserid());
        int owner_id = uSsoUserEdu.getEduId();
        int owner_type = uSsoUserEdu.getEduType();
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        byte[] bytes=null;
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return new ReturnT(ReturnT.FAIL_CODE,"file is empty");
        }
        try {
            bytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
            return new ReturnT(ReturnT.FAIL_CODE,"文件上传失败");
        }
        UaffairsFiles uaffairsFiles = new UaffairsFiles();
        uaffairsFiles.setFileName(fileName);
        uaffairsFiles.setContent(bytes);
        int file_id = (int) uaffairsFilesService.addUaffairsFiles(uaffairsFiles);
        UNoteFile uNoteFile = new UNoteFile();
        uNoteFile.setName(fileName);
        uNoteFile.setType(fileType);
        uNoteFile.setSubject(subject);
        uNoteFile.setOwnerId(owner_id);
        uNoteFile.setOwnerType(owner_type);
        uNoteFile.setStoreTool(1);
        uNoteFile.setStoreId(file_id);
        long uNoteFileId = uNoteFileService.addUNoteFile(uNoteFile);
        return new ReturnT(ReturnT.SUCCESS_CODE,String.valueOf(uNoteFileId));
    }


    @RequestMapping(value = "/getId",method = RequestMethod.GET)
    public ReturnT<String> getId(HttpServletRequest request){
        XxlUser xxlUser = (XxlUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT(xxlUser.getUsername());
    }





    //    public ReturnT<String> singleFileUpload(HttpServletRequest request,MultipartFile file){
//        logger.debug("上传文件");
//        XxlUser xxlUser = (XxlUser) request.getAttribute(Conf.SSO_USER);
//        USsoUserEdu uSsoUserEdu = userInformationService.getUSsoUserEduById(xxlUser.getUserid());
//        int id = uSsoUserEdu.getEduId();
//        int type = uSsoUserEdu.getEduType();
//        if (Objects.isNull(file) || file.isEmpty()) {
//            logger.error("文件为空");
//            return new ReturnT(500,"file is empty");
//        }
//
//        return null;
//    }
}
