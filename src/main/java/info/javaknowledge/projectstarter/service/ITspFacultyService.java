/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.TspFaculty;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface ITspFacultyService {

    List<TspFaculty> getAllObject();

    TspFaculty getObjectById(int id);

    boolean addObject(TspFaculty obj);

    void updateObject(TspFaculty obj);

    void deleteObject(int id);
}
