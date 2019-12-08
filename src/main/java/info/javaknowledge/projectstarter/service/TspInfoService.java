/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.ITspInfoDAO;
import info.javaknowledge.projectstarter.domain.TspInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class TspInfoService implements ITspInfoService{
    
    @Autowired
    private ITspInfoDAO iTspInfoDAO;
    
    @Override
    public List<TspInfo> getAllTspInfo() {
        return iTspInfoDAO.getAllTspInfo();
    }

    @Override
    public TspInfo getTspById(int tspid) {
        TspInfo obj = iTspInfoDAO.getTspById(tspid);
        return obj;
    }

    @Override
    public synchronized boolean addTsp(TspInfo tspInfo) {
        if (iTspInfoDAO.tspExists(tspInfo.getTspName(), tspInfo.getTspLocation())) {
            return false;
        } else {
            iTspInfoDAO.addTsp(tspInfo);
            return true;
        }
    }

    @Override
    public void updateTsp(TspInfo tspInfo) {
        iTspInfoDAO.updateTsp(tspInfo);
    }

    @Override
    public void deleteTsp(int tspid) {
        iTspInfoDAO.deleteTsp(tspid);
    }
    
}
