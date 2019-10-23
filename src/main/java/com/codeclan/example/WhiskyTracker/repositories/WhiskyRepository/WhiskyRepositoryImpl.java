package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskyByAParticularRegion(String regionToFind) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try{
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.createAlias("distilleries", "distilleryAlias");
            criteria.add(Restrictions.eq("distilleryAlias.region", regionToFind));
            result = criteria.list();
        }
        catch(HibernateException exception) {
            System.out.println("You broke it, you fool! ヽ(｀Д´)ﾉ");
            exception.printStackTrace();
        }
        return result;
    }

}
