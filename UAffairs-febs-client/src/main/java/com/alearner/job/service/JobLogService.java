package com.alearner.job.service;

import java.util.List;


import com.alearner.common.service.IService;
import com.alearner.job.domain.JobLog;

public interface JobLogService extends IService<JobLog> {

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);
	
	void deleteBatch(String jobLogIds);
}
