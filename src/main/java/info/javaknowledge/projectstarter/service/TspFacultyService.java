/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.ITspFacultyDAO;
import info.javaknowledge.projectstarter.domain.TspFaculty;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class TspFacultyService implements ITspFacultyService {

    @Autowired
    private ITspFacultyDAO iTspFacultyDAO;

    @Override
    public List<TspFaculty> getAllObject() {
        return iTspFacultyDAO.getAllObject();
    }

    @Override
    public TspFaculty getObjectById(int id) {
        TspFaculty obj = iTspFacultyDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(TspFaculty obj) {
        if (iTspFacultyDAO.objectExists(obj.getTspInfo().getTspId(), obj.getFacultyName())) {
            return false;
        } else {
            iTspFacultyDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(TspFaculty obj) {
        iTspFacultyDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iTspFacultyDAO.deleteObject(id);
    }

}
