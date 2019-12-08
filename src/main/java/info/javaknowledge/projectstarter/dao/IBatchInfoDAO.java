/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.BatchInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IBatchInfoDAO {

    List<BatchInfo> getAllObject();

    BatchInfo getObjectById(int id);

    void addObject(BatchInfo obj);

    void updateObject(BatchInfo obj);

    void deleteObject(int id);

    boolean objectExists(String name);
}
