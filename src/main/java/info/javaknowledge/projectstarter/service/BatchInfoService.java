/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.IBatchInfoDAO;
import info.javaknowledge.projectstarter.domain.BatchInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class BatchInfoService implements IBatchInfoService {

    @Autowired
    private IBatchInfoDAO iBatchInfoDAO;

    @Override
    public List<BatchInfo> getAllObject() {
        return iBatchInfoDAO.getAllObject();
    }

    @Override
    public BatchInfo getObjectById(int id) {
        BatchInfo obj = iBatchInfoDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(BatchInfo obj) {
        if (iBatchInfoDAO.objectExists(obj.getBatchName())) {
            return false;
        } else {
            iBatchInfoDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(BatchInfo obj) {
        iBatchInfoDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iBatchInfoDAO.deleteObject(id);
    }

}
