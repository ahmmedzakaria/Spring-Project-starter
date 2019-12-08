/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.ITspTcDAO;
import info.javaknowledge.projectstarter.domain.TspTc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class TspTcService implements ITspTcService {

    @Autowired
    private ITspTcDAO iTspTcDAO;

    @Override
    public List<TspTc> getAllObject() {
        return iTspTcDAO.getAllObject();
    }

    @Override
    public TspTc getObjectById(int id) {
        TspTc obj = iTspTcDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(TspTc obj) {
        if (iTspTcDAO.objectExists(obj.getTspInfo().getTspId(), obj.getTcName())) {
            return false;
        } else {
            iTspTcDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(TspTc obj) {
        iTspTcDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iTspTcDAO.deleteObject(id);
    }

}
