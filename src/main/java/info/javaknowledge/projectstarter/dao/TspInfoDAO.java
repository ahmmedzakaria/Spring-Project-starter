/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.TspInfo;
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
public class TspInfoDAO implements ITspInfoDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<TspInfo> getAllTspInfo() {
        String hql = "FROM TspInfo as tsp ORDER BY tsp.tspId";
        return (List<TspInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public TspInfo getTspById(int tspid) {
        return hibernateTemplate.get(TspInfo.class, tspid);
    }

    @Override
    public void addTsp(TspInfo tspInfo) {
        hibernateTemplate.save(tspInfo);
    }

    @Override
    public void updateTsp(TspInfo tspInfo) {
        TspInfo t = getTspById(tspInfo.getTspId());
        t.setTspName(tspInfo.getTspName());
        t.setTspAddress(tspInfo.getTspAddress());
        t.setTspPhone(tspInfo.getTspPhone());
        t.setTspEmail(tspInfo.getTspEmail());
        t.setTspLocation(tspInfo.getTspLocation());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteTsp(int tspid) {
         hibernateTemplate.delete(getTspById(tspid));
    }

    @Override
    public boolean tspExists(String name, String location) {
        String hql = "FROM TspInfo as p WHERE p.tspName = ? and p.tspLocation = ?";
        List<TspInfo> tspList = (List<TspInfo>) hibernateTemplate.find(hql, name, location);
        return tspList.size() > 0 ? true : false;
    }

    
    
}
