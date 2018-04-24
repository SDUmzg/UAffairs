package com.alearner.system.service;


import com.alearner.common.service.IService;
import com.alearner.system.domain.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

	List<Dict> findAllDicts(Dict dict);

	Dict findById(Long dictId);

	void addDict(Dict dict);

	void deleteDicts(String dictIds);

	void updateDict(Dict dicdt);
}
