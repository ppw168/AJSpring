package com.salientCrgt.hudStack.service;

import java.util.List;

import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;

public interface CaivrsService {

	public List<F57AgencyEntity> getAgencyList();
	
	public List<F57BorrowerEntity> getBorrowerBySsn(String ssn);
	
	public List<F57BorrowerEntity> getBorrowerBySsnAgencyCode(String ssn, String code);
  
}
