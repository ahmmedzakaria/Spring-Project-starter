/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.ExamMarks;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IExamMarksService {

    List<ExamMarks> getAllObject();

    ExamMarks getObjectById(int id);

    boolean addObject(ExamMarks obj);

    void updateObject(ExamMarks obj);

    void deleteObject(int id);
}
