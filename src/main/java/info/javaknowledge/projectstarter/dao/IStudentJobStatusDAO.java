/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.StudentJobStatus;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IStudentJobStatusDAO {

    List<StudentJobStatus> getAllObject();

    StudentJobStatus getObjectById(int id);

    void addObject(StudentJobStatus obj);

    void updateObject(StudentJobStatus obj);

    void deleteObject(int id);

    boolean objectExists(int studentid, String companyname);
}
