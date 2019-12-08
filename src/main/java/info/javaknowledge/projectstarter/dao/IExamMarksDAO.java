/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.dao;

import info.javaknowledge.projectstarter.domain.ExamMarks;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IExamMarksDAO {

    List<ExamMarks> getAllObject();

    ExamMarks getObjectById(int id);

    void addObject(ExamMarks obj);

    void updateObject(ExamMarks obj);

    void deleteObject(int id);

    boolean objectExists(int examid, int student_id);
}
