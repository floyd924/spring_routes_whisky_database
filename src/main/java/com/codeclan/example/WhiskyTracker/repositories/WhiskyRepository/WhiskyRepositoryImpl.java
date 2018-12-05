package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {


    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getWhiskyByYear(int year){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);

        cr.add(Restrictions.eq("year", year));

        result = cr.list();

        return result;
    }

    @Transactional
    public List<Whisky> getWhiskyByRegion(String region){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);

        cr.createAlias("distillery", "distillery");
        cr.add(Restrictions.eq("distillery.region", region));

        result = cr.list();

        return result;
    }

    @Transactional
    public List<Whisky> getWhiskyFromDistilleryWithAge(String distilleryName, int age){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);

        cr.createAlias("distillery", "dist");
        cr.add(Restrictions.eq("dist.name", distilleryName));
        cr.add(Restrictions.eq("age", age));

        result = cr.list();

        return result;
    }
}
