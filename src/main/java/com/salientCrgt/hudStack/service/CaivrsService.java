package com.salientCrgt.hudStack.service;

import java.util.List;

import com.salientCrgt.hudStack.bean.CaivrsLookup;
import com.salientCrgt.hudStack.bean.CaivrsReturn;
import com.salientCrgt.hudStack.model.F57AgencyEntity;

public interface CaivrsService {

	public List<F57AgencyEntity> getAgencyList();
	
	public CaivrsReturn authSearch(CaivrsLookup cl);
  
}
