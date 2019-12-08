/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.TspTc;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface ITspTcDAO {

    List<TspTc> getAllObject();

    TspTc getObjectById(int id);

    void addObject(TspTc obj);

    void updateObject(TspTc obj);

    void deleteObject(int id);

    boolean objectExists(int tspid, String tcname);
}
