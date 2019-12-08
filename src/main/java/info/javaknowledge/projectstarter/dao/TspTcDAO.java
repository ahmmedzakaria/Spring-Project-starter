/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.TspTc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Faculty
 */
@Transactional
@Repository
public class TspTcDAO implements ITspTcDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<TspTc> getAllObject() {
        String hql = "FROM TspTc as p ORDER BY p.tcId";
        return (List<TspTc>) hibernateTemplate.find(hql);
    }

    @Override
    public TspTc getObjectById(int id) {
        return hibernateTemplate.get(TspTc.class, id);
    }

    @Override
    public void addObject(TspTc obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(TspTc obj) {
        TspTc t = getObjectById(obj.getTcId());
        t.setTspInfo(obj.getTspInfo());
        t.setTcName(obj.getTcName());
        t.setTcEmail(obj.getTcEmail());
        t.setTcPhone(obj.getTcPhone());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int tspid, String tcname) {
        String hql = "FROM TspTc as p WHERE p.tspInfo.tspId = ? and p.tcName = ?";
        List<TspTc> lst = (List<TspTc>) hibernateTemplate.find(hql, tspid, tcname);
        return lst.size() > 0 ? true : false;
    }

    
    
}
