/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.BatchInfo;
import info.javaknowledge.projectstarter.domain.ExamSchedule;
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
public class ExamScheduleDAO implements IExamScheduleDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<ExamSchedule> getAllObject() {
        String hql = "FROM ExamSchedule as p ORDER BY p.examId";
        return (List<ExamSchedule>) hibernateTemplate.find(hql);
    }

    @Override
    public ExamSchedule getObjectById(int id) {
        return hibernateTemplate.get(ExamSchedule.class, id);
    }

    @Override
    public void addObject(ExamSchedule obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(ExamSchedule obj) {
        ExamSchedule t = getObjectById(obj.getExamId());
        t.setTspInfo(obj.getTspInfo());
        t.setTspFaculty(obj.getTspFaculty());
        t.setBatchInfo(obj.getBatchInfo());
        t.setExamName(obj.getExamName());
        t.setExamDate(obj.getExamDate());
        t.setTotalMarks(obj.getTotalMarks());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int tspid, int faculty_id, String name) {
        String hql = "FROM ExamSchedule as p WHERE p.examId = ?";
        List<ExamSchedule> lst = (List<ExamSchedule>) hibernateTemplate.find(hql, name);
        return lst.size() > 0 ? true : false;
    }

    
    
}
