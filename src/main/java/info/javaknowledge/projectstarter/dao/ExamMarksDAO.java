/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.ExamMarks;
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
public class ExamMarksDAO implements IExamMarksDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<ExamMarks> getAllObject() {
        String hql = "FROM ExamMarks as p ORDER BY p.marksId";
        return (List<ExamMarks>) hibernateTemplate.find(hql);
    }

    @Override
    public ExamMarks getObjectById(int id) {
        return hibernateTemplate.get(ExamMarks.class, id);
    }

    @Override
    public void addObject(ExamMarks obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(ExamMarks obj) {
        ExamMarks t = getObjectById(obj.getMarksId());
        t.setExamSchedule(obj.getExamSchedule());
        //t.setStudentId(obj.getStudentId());
        t.setMarksObtained(obj.getMarksObtained());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(int examid, int student_id) {
        String hql = "FROM ExamMarks as p WHERE p.examSchedule.examId = ? and p.studentId=?";
        List<ExamMarks> lst = (List<ExamMarks>) hibernateTemplate.find(hql, examid, student_id);
        return lst.size() > 0 ? true : false;
    }

    
    
}
