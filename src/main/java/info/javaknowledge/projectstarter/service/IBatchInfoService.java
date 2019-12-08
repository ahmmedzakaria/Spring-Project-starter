/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.dao.*;
import info.javaknowledge.projectstarter.domain.BatchInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IBatchInfoService {

    List<BatchInfo> getAllObject();

    BatchInfo getObjectById(int id);

    boolean addObject(BatchInfo obj);

    void updateObject(BatchInfo obj);

    void deleteObject(int id);
}
