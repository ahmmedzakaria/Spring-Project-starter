/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.service;

import info.javaknowledge.projectstarter.domain.Person;
import java.util.List;

/**
 *
 * @author Faculty
 */
public interface IPersonService {

    List<Person> getAllPersons();

    Person getPersonById(int pid);

    boolean addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int pid);
}
