/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.IExamScheduleDAO;
import info.javaknowledge.projectstarter.domain.ExamSchedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class ExamScheduleService implements IExamScheduleService {

    @Autowired
    private IExamScheduleDAO iExamScheduleDAO;

    @Override
    public List<ExamSchedule> getAllObject() {
        return iExamScheduleDAO.getAllObject();
    }

    @Override
    public ExamSchedule getObjectById(int id) {
        ExamSchedule obj = iExamScheduleDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(ExamSchedule obj) {
        if (iExamScheduleDAO.objectExists(obj.getTspInfo().getTspId(), obj.getTspFaculty().getFacultyId(), obj.getExamName())) {
            return false;
        } else {
            iExamScheduleDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(ExamSchedule obj) {
        iExamScheduleDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iExamScheduleDAO.deleteObject(id);
    }

}
