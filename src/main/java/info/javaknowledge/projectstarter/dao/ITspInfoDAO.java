/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.TspInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface ITspInfoDAO {

    List<TspInfo> getAllTspInfo();

    TspInfo getTspById(int tspid);

    void addTsp(TspInfo tspInfo);

    void updateTsp(TspInfo tspInfo);

    void deleteTsp(int tspid);

    boolean tspExists(String name, String location);
}
