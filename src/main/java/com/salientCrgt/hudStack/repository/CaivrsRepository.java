package com.salientCrgt.hudStack.repository;

import java.util.List;

import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;

public interface CaivrsRepository {

    public List<F57BorrowerEntity> findBySsn(String ssn);

    public List<F57BorrowerEntity> findBySsnAgencyCode(String ssn,
            String agencyCode);

    public List<F57AgencyEntity> getAgencyList();
}
