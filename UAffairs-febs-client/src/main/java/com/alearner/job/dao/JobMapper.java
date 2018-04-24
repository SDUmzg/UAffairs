package com.alearner.job.dao;

import java.util.List;

import com.alearner.common.config.MyMapper;
import com.alearner.job.domain.Job;

public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}