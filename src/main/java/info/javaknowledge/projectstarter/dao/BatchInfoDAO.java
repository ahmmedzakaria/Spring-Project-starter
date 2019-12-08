/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.BatchInfo;
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
public class BatchInfoDAO implements IBatchInfoDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<BatchInfo> getAllObject() {
        String hql = "FROM BatchInfo as p ORDER BY p.batchId";
        return (List<BatchInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public BatchInfo getObjectById(int id) {
        return hibernateTemplate.get(BatchInfo.class, id);
    }

    @Override
    public void addObject(BatchInfo obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(BatchInfo obj) {
        BatchInfo t = getObjectById(obj.getBatchId());
        t.setTspInfo(obj.getTspInfo());
        t.setBatchName(obj.getBatchName());
        t.setStartDate(obj.getStartDate());
        t.setEndDate(obj.getEndDate());
        t.setBatchRound(obj.getBatchRound());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name) {
        String hql = "FROM BatchInfo as p WHERE p.batchName = ?";
        List<BatchInfo> lst = (List<BatchInfo>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

    
    
}
