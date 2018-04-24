package com.alearner.system.service;


import com.alearner.system.domain.UserOnline;

import java.util.List;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
