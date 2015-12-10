package com.salientCrgt.hudStack.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.salientCrgt.hudStack.model.F57AgencyEntity;
import com.salientCrgt.hudStack.model.F57BorrowerEntity;
import com.salientCrgt.hudStack.utils.AppUtils;

@Repository
public class CaivrsRepositoryImpl implements CaivrsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<F57BorrowerEntity> findBySsn(String ssn) {

		Query query = this.entityManager.createNamedQuery("F57BorrowerEntity.findBySsn", F57BorrowerEntity.class);
		query.setParameter("ssn", ssn);
		List<?> list = query.getResultList();
		return AppUtils.castList(F57BorrowerEntity.class, list);
		
	}

	public List<F57BorrowerEntity> findBySsnAgencyCode(String ssn, String agencyCode) {

		Query query = this.entityManager.createNamedQuery("F57BorrowerEntity.findBySsnAgency");
		query.setParameter("ssn", ssn);
		query.setParameter("code", agencyCode);
		List<?> list = query.getResultList();
		return AppUtils.castList(F57BorrowerEntity.class, list);
		
	}
	
	public List<F57AgencyEntity> getAgencyList() {
		
		Query query = this.entityManager.createNamedQuery("F57AgencyEntity.findAll");		
		return AppUtils.castList(F57AgencyEntity.class, query.getResultList());
		
	}
	
}
