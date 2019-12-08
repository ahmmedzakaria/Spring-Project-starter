/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.TspFaculty;
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
public class TspFacultyDAO implements ITspFacultyDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<TspFaculty> getAllObject() {
//        String hql = "SELECT p FROM TspFaculty as p, TspInfo as i where p.tspInfo.tspId=i.tspId ORDER BY p.facultyId";
        String hql = "FROM TspFaculty p LEFT JOIN FETCH  p.tspInfo ORDER BY p.facultyId";
        return (List<TspFaculty>) hibernateTemplate.find(hql);
    }

    @Override
    public TspFaculty getObjectById(int id) {
        return hibernateTemplate.get(TspFaculty.class, id);
    }

    @Override
    public void addObject(TspFaculty obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(TspFaculty obj) {
        TspFaculty t = getObjectById(obj.getFacultyId());
        t.setTspInfo(obj.getTspInfo());
        t.setFacultyCode(obj.getFacultyCode());
        t.setFacultyName(obj.getFacultyName());
        t.setFacultyEmail(obj.getFacultyEmail());
        t.setFacultyPhone(obj.getFacultyPhone());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int tspid, String facultyname) {
        String hql = "FROM TspFaculty as p WHERE p.tspInfo.tspId = ? and p.facultyName=?";
        List<TspFaculty> lst = (List<TspFaculty>) hibernateTemplate.find(hql, tspid, facultyname);
        return lst.size() > 0 ? true : false;
    }

    
    
}
