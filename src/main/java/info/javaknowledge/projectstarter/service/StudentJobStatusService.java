/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.IStudentJobStatusDAO;
import info.javaknowledge.projectstarter.domain.StudentJobStatus;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentJobStatusService implements IStudentJobStatusService {

    @Autowired
    private IStudentJobStatusDAO iStudentJobStatusDAO;

    @Override
    public List<StudentJobStatus> getAllObject() {
        return iStudentJobStatusDAO.getAllObject();
    }

    @Override
    public StudentJobStatus getObjectById(int id) {
        StudentJobStatus obj = iStudentJobStatusDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(StudentJobStatus obj) {
        if (iStudentJobStatusDAO.objectExists(obj.getStudentInfo().getStudentId(), obj.getCompanyName())) {
            return false;
        } else {
            iStudentJobStatusDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(StudentJobStatus obj) {
        iStudentJobStatusDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iStudentJobStatusDAO.deleteObject(id);
    }

}
