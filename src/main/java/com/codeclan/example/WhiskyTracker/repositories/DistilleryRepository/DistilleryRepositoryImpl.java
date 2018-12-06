package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> getDistilleryByRegion(String region){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);

        cr.add(Restrictions.eq("region", region));

        result = cr.list();

        return result;
    }

    @Transactional
    public List<Distillery> getDistilleryByWhiskyAge(int age){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);

        cr.createAlias("whisky", "wh");
        cr.add(Restrictions.eq("wh.age", age));

        result = cr.list();

        return result;
    }

    @Transactional
    public List<Distillery> getDistilleriesForWhiskyAge(int age){
        List<Distillery> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);

        cr.createAlias("whiskies", "wh");
        cr.add(Restrictions.eq("wh.age", age));


        results = cr.list();

        return results;
    }
}
