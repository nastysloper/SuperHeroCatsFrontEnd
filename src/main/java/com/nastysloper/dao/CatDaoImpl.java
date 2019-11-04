package com.nastysloper.dao;

import com.nastysloper.model.Cat;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("catDao")
public class CatDaoImpl extends AbstractDao implements CatDao {

    @Override
    public void saveCat(Cat cat) {
        persist(cat);
    }

    @Override
    public ArrayList<Cat> findAllCats() {
        Criteria criteria = getSession().createCriteria(Cat.class);
        return (ArrayList<Cat>) criteria.list();
    }

    @Override
    public void deleteCatById(Long id) {
        Query query = getSession().createSQLQuery("delete from Cat where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @Override
    public Cat findById(Long id) {
        Criteria criteria = getSession().createCriteria(Cat.class);
        criteria.add(Restrictions.eq("id", id));
        return (Cat) criteria.uniqueResult();
    }

    @Override
    public Cat findByName(String name) {
        Criteria criteria = getSession().createCriteria(Cat.class);
        criteria.add(Restrictions.eq("name", name));
        return (Cat) criteria.uniqueResult();
    }

    @Override
    public void updateCat(Cat cat) {
        getSession().update(cat);
    }
}
