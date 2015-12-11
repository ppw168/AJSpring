package com.salientCrgt.hudStack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.salientCrgt.hudStack.bean.CaivrsLookup;
import com.salientCrgt.hudStack.bean.CaivrsReturn;
import com.salientCrgt.hudStack.exception.CaivrsException;
import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.service.CaivrsService;

@Controller
@RequestMapping(value = "/caivrsAuth")
// @CrossOrigin(origins = "http://127.0.0.1:64990")
public class CaivrsAuthController {

    @Autowired
    private CaivrsService caivrsService;

    @RequestMapping(value = "/authDetails", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public CaivrsReturn authLookup(@RequestBody final CaivrsLookup cl) throws CaivrsException {

        return this.caivrsService.authSearch(cl);

    }

    @RequestMapping(value = "/agencyList", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public List<F57AgencyEntity> getAgencyList() {

        return this.caivrsService.getAgencyList();

    }
}
