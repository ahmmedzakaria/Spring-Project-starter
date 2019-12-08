/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.ExamSchedule;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IExamScheduleDAO {

    List<ExamSchedule> getAllObject();

    ExamSchedule getObjectById(int id);

    void addObject(ExamSchedule obj);

    void updateObject(ExamSchedule obj);

    void deleteObject(int id);

    boolean objectExists(int tspid, int faculty_id, String name);
}
