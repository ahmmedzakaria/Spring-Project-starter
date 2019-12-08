/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.StudentInfo;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IStudentInfoDAO {

    List<StudentInfo> getAllObject();

    StudentInfo getObjectById(int id);

    void addObject(StudentInfo obj);

    void updateObject(StudentInfo obj);

    void deleteObject(int id);

    boolean objectExists(String studentname, int batchid);
}
