/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.LoginInfo;
import info.javaknowledge.projectstarter.domain.UserRole;
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
public class LoginInfoDAO implements ILoginInfoDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<LoginInfo> getAllObject() {
        String hql = "FROM LoginInfo as p ORDER BY p.loginId";
        return (List<LoginInfo>) hibernateTemplate.find(hql);
    }

    @Override
    public LoginInfo getObjectById(int id) {
        return hibernateTemplate.get(LoginInfo.class, id);
    }

    @Override
    public void addObject(LoginInfo obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(LoginInfo obj) {
        LoginInfo t = getObjectById(obj.getLoginId());
        t.setTspInfo(obj.getTspInfo());
        t.setUserRole(obj.getUserRole());
        //t.setUserId(obj.getUserId());
        t.setUserName(obj.getUserName());
        t.setUserPassword(obj.getUserPassword());
        t.setStatus(obj.getStatus());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String name, String pass) {
        String hql = "FROM LoginInfo as p WHERE p.userName = ? and p.userPassword = ? and p.status = 1";
        List<LoginInfo> lst = (List<LoginInfo>) hibernateTemplate.find(hql, name, pass);
        return lst.size() > 0 ? true : false;
    }

    
    
}
