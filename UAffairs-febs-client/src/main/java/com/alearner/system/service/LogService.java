package com.alearner.system.service;


import com.alearner.common.service.IService;
import com.alearner.system.domain.SysLog;

import java.util.List;

public interface LogService extends IService<SysLog> {
	
	List<SysLog> findAllLogs(SysLog log);
	
	void deleteLogs(String logIds);
}
