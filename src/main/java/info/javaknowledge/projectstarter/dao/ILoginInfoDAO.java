/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.LoginInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface ILoginInfoDAO {

    List<LoginInfo> getAllObject();

    LoginInfo getObjectById(int id);

    void addObject(LoginInfo obj);

    void updateObject(LoginInfo obj);

    void deleteObject(int id);

    boolean objectExists(String name, String pass);
}
