package com.salientCrgt.hudStack.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salientCrgt.hudStack.bean.CaivrsAuthDetail;
import com.salientCrgt.hudStack.bean.CaivrsAuthEntry;
import com.salientCrgt.hudStack.bean.CaivrsBorrower;
import com.salientCrgt.hudStack.bean.CaivrsLookup;
import com.salientCrgt.hudStack.bean.CaivrsReturn;
import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;
import com.salientCrgt.hudStack.repository.CaivrsRepository;
import com.salientCrgt.hudStack.utils.AppUtils;

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

	public CaivrsReturn authSearch(CaivrsLookup caivrsLookup) {
		CaivrsReturn cr = new CaivrsReturn();
		
		Map<String, String> errors = droolsValidate(caivrsLookup);
		// System.out.println(errors);
		if (!errors.isEmpty())
		{
			StringBuffer sb = new StringBuffer("Error: ");
			for (String key : errors.keySet()) {
				sb.append(errors.get(key));
			}
			cr.setStatus(sb.toString());
			return cr;
		}
		
				
		
		CaivrsAuthDetail cad = null;
		CaivrsAuthEntry cae = null;		

		for (CaivrsBorrower cb : caivrsLookup.getCaivrsBorrowerList()) {
			cad = new CaivrsAuthDetail();
			cad.setBorrowerLabel(cb.getBorrowerLabel());
			cad.setIndicator(cb.getIndicator());
			if (cb != null && !AppUtils.isEmptyString(cb.getSsn())) {
				cad.setSsn(cb.getSsn());
				cad.setAuthNo("####");

				List<F57BorrowerEntity> l = null;
				if (AppUtils.isEmptyString(caivrsLookup.getAgencyCode()))
					l = getBorrowerBySsn(cb.getSsn());
				else
					l = getBorrowerBySsnAgencyCode(cb.getSsn(), caivrsLookup.getAgencyCode());
				
				cad.setCaivrsBorrowerList(l);
				errors = droolsValidate(cad);
				// System.out.println(errors);
				if (!errors.isEmpty())
				{
					StringBuffer sb = new StringBuffer("Error: ");
					for (String key : errors.keySet()) {
						sb.append(errors.get(key));
					}
					cad.setStatus(sb.toString());
				}
				
//				for (F57BorrowerEntity e : l) {
//					cae = new CaivrsAuthEntry();
//					cae.setAgency(e.getF57Agency().getTxName());
//					cae.setCaseNo(e.getId().getTxCaseNo());
//					cae.setCaseType(e.getF57RefCaseCodeEntity().getTxDescription());
//					cae.setPhone(e.getF57Agency().getTxPhone());
//					cad.getCaivrsAuthEntryList().add(cae);
//				}
			} else {
				cad.setSsn("N/A");
				cad.setAuthNo("");
			}
			cr.getCaivrsAuthDetailList().add(cad);
		}
		cr.setStatus("Success!");
		return cr;
	}

	public Map<String, String> droolsValidate(Object o) {
		Map<String, String> errors = new HashMap<String, String>();
		KieSession kieSession = kieContainer.newKieSession("hudStackSession");
		kieSession.insert(o);
		kieSession.insert(errors);
		kieSession.fireAllRules();
		kieSession.dispose();
		return errors;
	}
	
	public List<F57BorrowerEntity> getBorrowerBySsn(String ssn) {

		// Map<String, String> error1 = new HashMap<String, String>();
		List<F57BorrowerEntity> borrowerList = caivrsRepo.findBySsn(ssn);
		// KieSession kieSession = kieContainer.newKieSession("hudStackSession");
		// F57BorrowerEntity entity = new F57BorrowerEntity();
		// entity.setTxSuspendCode("aaa");
		// kieSession.insert(entity);
		// kieSession.insert(borrowerList);
		// kieSession.insert(error1);
		// kieSession.fireAllRules();
		// BusPass busPass = findBusPass(kieSession);
		// kieSession.dispose();
		// return busPass;
		return borrowerList;
	}

	public List<F57BorrowerEntity> getBorrowerBySsnAgencyCode(String ssn, String code) {
		return caivrsRepo.findBySsnAgencyCode(ssn, code);
	}
}
