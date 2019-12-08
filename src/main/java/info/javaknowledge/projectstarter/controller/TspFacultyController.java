/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.controller;

import info.javaknowledge.projectstarter.domain.TspFaculty;
import info.javaknowledge.projectstarter.service.ITspFacultyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Faculty
 */
@Controller
@RequestMapping("/faculty")
public class TspFacultyController {

    @Autowired
    private ITspFacultyService iTspFacultyService;

    @RequestMapping("/home")
    public String home() {
        return "faculty";
    }
    @RequestMapping(value = "/facultylist", method = RequestMethod.GET)
    public ResponseEntity<List<TspFaculty>> getAllFaculty() {
        List<TspFaculty> list = iTspFacultyService.getAllObject();
        return new ResponseEntity<List<TspFaculty>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/facultylist/{id}", method = RequestMethod.GET)
    public ResponseEntity<TspFaculty> getObjectById(@PathVariable("id") Integer id) {
        TspFaculty tspFaculty = iTspFacultyService.getObjectById(id);
        return new ResponseEntity<TspFaculty>(tspFaculty, HttpStatus.OK);
    }

    @RequestMapping(value = "/facultylist", method = RequestMethod.POST)
    public ResponseEntity<Void> addObject(@RequestBody TspFaculty tspFaculty, UriComponentsBuilder builder) {
        boolean flag = iTspFacultyService.addObject(tspFaculty);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/facultylist/{id}").buildAndExpand(tspFaculty.getFacultyId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/facultylist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TspFaculty> updateTsp(@RequestBody TspFaculty tspInfo) {
        iTspFacultyService.updateObject(tspInfo);
        return new ResponseEntity<TspFaculty>(tspInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/facultylist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteObject(@PathVariable("id") Integer id) {
        iTspFacultyService.deleteObject(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
