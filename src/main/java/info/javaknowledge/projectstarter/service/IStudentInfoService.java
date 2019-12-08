/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.StudentInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IStudentInfoService {

    List<StudentInfo> getAllObject();

    StudentInfo getObjectById(int id);

    boolean addObject(StudentInfo obj);

    void updateObject(StudentInfo obj);

    void deleteObject(int id);
}
