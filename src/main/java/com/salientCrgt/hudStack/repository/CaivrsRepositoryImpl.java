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

    @Override
    public List<F57BorrowerEntity> findBySsn(final String ssn) {

        final Query query = this.entityManager.createNamedQuery(
                "F57BorrowerEntity.findBySsn", F57BorrowerEntity.class);
        query.setParameter("ssn", ssn);
        final List<?> list = query.getResultList();
        return AppUtils.castList(F57BorrowerEntity.class, list);

    }

    @Override
    public List<F57BorrowerEntity> findBySsnAgencyCode(final String ssn,
            final String agencyCode) {

        final Query query = this.entityManager
                .createNamedQuery("F57BorrowerEntity.findBySsnAgency");
        query.setParameter("ssn", ssn);
        query.setParameter("code", agencyCode);
        final List<?> list = query.getResultList();
        return AppUtils.castList(F57BorrowerEntity.class, list);

    }

    @Override
    public List<F57AgencyEntity> getAgencyList() {

        final Query query = this.entityManager
                .createNamedQuery("F57AgencyEntity.findAll");
        return AppUtils.castList(F57AgencyEntity.class, query.getResultList());

    }

}
