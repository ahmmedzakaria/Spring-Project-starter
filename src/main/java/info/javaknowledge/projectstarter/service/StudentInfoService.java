/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.IStudentInfoDAO;
import info.javaknowledge.projectstarter.domain.StudentInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class StudentInfoService implements IStudentInfoService {

    @Autowired
    private IStudentInfoDAO iStudentInfoDAO;

    @Override
    public List<StudentInfo> getAllObject() {
        return iStudentInfoDAO.getAllObject();
    }

    @Override
    public StudentInfo getObjectById(int id) {
        StudentInfo obj = iStudentInfoDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(StudentInfo obj) {
        if (iStudentInfoDAO.objectExists(obj.getStudentName(), obj.getBatchInfo().getBatchId())) {
            return false;
        } else {
            iStudentInfoDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(StudentInfo obj) {
        iStudentInfoDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iStudentInfoDAO.deleteObject(id);
    }

}
