/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.IExamMarksDAO;
import info.javaknowledge.projectstarter.domain.ExamMarks;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class ExamMarksService implements IExamMarksService {

    @Autowired
    private IExamMarksDAO iExamMarksDAO;

    @Override
    public List<ExamMarks> getAllObject() {
        return iExamMarksDAO.getAllObject();
    }

    @Override
    public ExamMarks getObjectById(int id) {
        ExamMarks obj = iExamMarksDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(ExamMarks obj) {
        if (iExamMarksDAO.objectExists(obj.getExamSchedule().getExamId(), obj.getStudentInfo().getStudentId())) {
            return false;
        } else {
            iExamMarksDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(ExamMarks obj) {
        iExamMarksDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iExamMarksDAO.deleteObject(id);
    }

}
