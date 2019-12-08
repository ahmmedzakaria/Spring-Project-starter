/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.StudentInfo;
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
public class StudentInfoDAO implements IStudentInfoDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    

    @Override
    public List<StudentInfo> getAllObject() {
        String hql = "FROM StudentInfo as p ORDER BY p.studentId";
        return (List<StudentInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentInfo getObjectById(int id) {
        return hibernateTemplate.get(StudentInfo.class, id);
    }

    @Override
    public void addObject(StudentInfo obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(StudentInfo obj) {
        StudentInfo t = getObjectById(obj.getStudentId());
        t.setTspInfo(obj.getTspInfo());
        t.setBatchInfo(obj.getBatchInfo());
        t.setStudentName(obj.getStudentName());
        t.setStudentAddress(obj.getStudentAddress());
        t.setStudentEmail(obj.getStudentEmail());
        t.setStudentPhone(obj.getStudentPhone());
        t.setStudentFatherName(obj.getStudentFatherName());
        t.setStudentMotherName(obj.getStudentMotherName());
        t.setStudentDateOfBirth(obj.getStudentDateOfBirth());
        t.setStudentId(obj.getStudentId());
        t.setStudentPhoneLink(obj.getStudentPhoneLink());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String studentname, int batchid) {
        String hql = "FROM StudentInfo as p WHERE p.studentName = ? and p.batchInfo.batchId = ?";
        List<StudentInfo> tspList = (List<StudentInfo>) hibernateTemplate.find(hql, studentname, batchid);
        return tspList.size() > 0 ? true : false;
    }

    
    
}
