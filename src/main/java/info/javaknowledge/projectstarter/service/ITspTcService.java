/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.TspTc;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface ITspTcService {

    List<TspTc> getAllObject();

    TspTc getObjectById(int id);

    boolean addObject(TspTc obj);

    void updateObject(TspTc obj);

    void deleteObject(int id);
}
