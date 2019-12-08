/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.StudentJobStatus;
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
public class StudentJobStatusDAO implements IStudentJobStatusDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    

    @Override
    public List<StudentJobStatus> getAllObject() {
        String hql = "FROM StudentJobStatus as p ORDER BY p.jobId";
        return (List<StudentJobStatus>) hibernateTemplate.find(hql);
    }

    @Override
    public StudentJobStatus getObjectById(int id) {
        return hibernateTemplate.get(StudentJobStatus.class, id);
    }

    @Override
    public void addObject(StudentJobStatus obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(StudentJobStatus obj) {
        StudentJobStatus t = getObjectById(obj.getJobId());
        t.setStudentInfo(obj.getStudentInfo());
        t.setCompanyName(obj.getCompanyName());
        t.setJoiningDate(obj.getJoiningDate());
        t.setStartingSalary(obj.getStartingSalary());
        t.setJobPosition(obj.getJobPosition());
        t.setCompanyLocation(obj.getCompanyLocation());
        t.setResignDate(obj.getResignDate());
        t.setStatus(obj.getStatus());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int studentid, String companyname) {
        String hql = "FROM StudentJobStatus as p WHERE p.studentInfo.studentId = ? and p.companyName = ?";
        List<StudentJobStatus> tspList = (List<StudentJobStatus>) hibernateTemplate.find(hql, studentid, companyname);
        return tspList.size() > 0 ? true : false;
    }

    
    
}
