/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.UserRole;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IUserRoleService {

    List<UserRole> getAllObject();

    UserRole getObjectById(int id);

    boolean addObject(UserRole obj);

    void updateObject(UserRole obj);

    void deleteObject(int id); 
}
