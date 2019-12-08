/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.ILoginInfoDAO;
import info.javaknowledge.projectstarter.domain.LoginInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faculty
 */
@Service
public class LoginInfoService implements ILoginInfoService {

    @Autowired
    private ILoginInfoDAO iLoginInfoDAO;

    @Override
    public List<LoginInfo> getAllObject() {
        return iLoginInfoDAO.getAllObject();
    }

    @Override
    public LoginInfo getObjectById(int id) {
        LoginInfo obj = iLoginInfoDAO.getObjectById(id);
        return obj;
    }

    @Override
    public synchronized boolean addObject(LoginInfo obj) {
        if (iLoginInfoDAO.objectExists(obj.getUserName(), obj.getUserPassword())) {
            return false;
        } else {
            iLoginInfoDAO.addObject(obj);
            return true;
        }
    }

    @Override
    public void updateObject(LoginInfo obj) {
        iLoginInfoDAO.updateObject(obj);
    }

    @Override
    public void deleteObject(int id) {
        iLoginInfoDAO.deleteObject(id);
    }

}
