package com.salientCrgt.hudStack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salientCrgt.hudStack.bean.CaivrsAuthDetail;
import com.salientCrgt.hudStack.bean.CaivrsAuthEntry;
import com.salientCrgt.hudStack.bean.CaivrsBorrower;
import com.salientCrgt.hudStack.bean.CaivrsLookup;
import com.salientCrgt.hudStack.bean.CaivrsReturn;
import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;
import com.salientCrgt.hudStack.service.CaivrsService;
import com.salientCrgt.hudStack.utils.AppUtils;

@Controller
@RequestMapping(value="/caivrsAuth")
// @CrossOrigin(origins = "http://127.0.0.1:64990")
public class CaivrsAuthController {
	
	@Autowired
    private CaivrsService caivrsService;

	@RequestMapping(value = "/authDetails", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public CaivrsReturn authLookup(@RequestBody CaivrsLookup cl) {

		CaivrsReturn cr = new CaivrsReturn();
		CaivrsAuthDetail cad = null;
		CaivrsAuthEntry cae = null;
		Map<String, String> errors = new HashMap<String, String>();

		for (CaivrsBorrower cb : cl.getCaivrsBorrowerList()) {
			cad = new CaivrsAuthDetail();
			cad.setBorrowerLabel(cb.getBorrowerLabel());
			cad.setIndicator(cb.getIndicator());
			if (cb != null && !AppUtils.isEmptyString(cb.getSsn())) {
				cad.setSsn(cb.getSsn());
				cad.setAuthNo("####");

				List<F57BorrowerEntity> l = null;
				if (AppUtils.isEmptyString(cl.getAgencyCode()))
					l = caivrsService.getBorrowerBySsn(cb.getSsn());
				else
					l = caivrsService.getBorrowerBySsnAgencyCode(cb.getSsn(), cl.getAgencyCode());
				for (F57BorrowerEntity e : l) {
					cae = new CaivrsAuthEntry();
					cae.setAgency(e.getF57Agency().getTxName());
					cae.setCaseNo(e.getId().getTxCaseNo());
					cae.setCaseType(e.getF57RefCaseCodeEntity().getTxDescription());
					cae.setPhone(e.getF57Agency().getTxPhone());
					cad.getCaivrsAuthEntryList().add(cae);
				}
			} else {
				cad.setSsn("N/A");
				cad.setAuthNo("");
			}
			cr.getCaivrsAuthDetailList().add(cad);
		}
		cr.setStatus("Success!");
		return cr;
	}
	
	@RequestMapping(value = "/agencyList", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<F57AgencyEntity> getAgencyList() {
		
		return caivrsService.getAgencyList();
		
	}
}
