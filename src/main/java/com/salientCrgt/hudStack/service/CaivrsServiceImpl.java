package com.salientCrgt.hudStack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;
import com.salientCrgt.hudStack.repository.CaivrsRepository;

@Service
public class CaivrsServiceImpl implements CaivrsService {

	private final KieContainer kieContainer;
	
	@Autowired
	private CaivrsRepository caivrsRepo;
	
    @Autowired
    public CaivrsServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }
	
	public List<F57AgencyEntity> getAgencyList() {		
		return caivrsRepo.getAgencyList();		
	}
	
	public List<F57BorrowerEntity> getBorrowerBySsn(String ssn) {
		
		// Map<String, String> error1 = new HashMap<String, String>();
		List<F57BorrowerEntity> borrowerList = caivrsRepo.findBySsn(ssn);
        KieSession kieSession = kieContainer.newKieSession("hudStackSession");
        F57BorrowerEntity entity = new F57BorrowerEntity();
        entity.setTxSuspendCode("aaa");
        kieSession.insert(entity);
        // kieSession.insert(borrowerList);
        // kieSession.insert(error1);
        kieSession.fireAllRules();
        // BusPass busPass = findBusPass(kieSession);
        kieSession.dispose();
        // return busPass;
		return borrowerList;
    }
	
	public List<F57BorrowerEntity> getBorrowerBySsnAgencyCode(String ssn, String code) {
		return caivrsRepo.findBySsnAgencyCode(ssn, code);
    }
}
