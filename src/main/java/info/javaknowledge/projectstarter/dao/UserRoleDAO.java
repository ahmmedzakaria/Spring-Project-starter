/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

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
public class UserRoleDAO implements IUserRoleDAO{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;    

    @Override
    public List<UserRole> getAllObject() {
        String hql = "FROM UserRole as p ORDER BY p.roleId";
        return (List<UserRole>) hibernateTemplate.find(hql);
    }

    @Override
    public UserRole getObjectById(int id) {
        return hibernateTemplate.get(UserRole.class, id);
    }

    @Override
    public void addObject(UserRole obj) {
        hibernateTemplate.save(obj);
    }

    @Override
    public void updateObject(UserRole obj) {
        UserRole t = getObjectById(obj.getRoleId());
        t.setRoleName(obj.getRoleName());
        hibernateTemplate.update(t);
    }

    @Override
    public void deleteObject(int id) {
        hibernateTemplate.delete(getObjectById(id));
    }

    @Override
    public boolean objectExists(String rolename) {
        String hql = "FROM UserRole as p WHERE p.roleName = ?";
        List<UserRole> lst = (List<UserRole>) hibernateTemplate.find(hql, rolename);
        return lst.size() > 0 ? true : false;
    }

    
    
}
