/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import info.javaknowledge.projectstarter.domain.TspInfo;
import info.javaknowledge.projectstarter.service.ITspInfoService;
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
@RequestMapping("/tsp")
public class TspInfoController {

    @Autowired
    private ITspInfoService iTspInfoService;

    @RequestMapping("/home")
    public String home() {
        return "tspinfo";
    }
    @RequestMapping(value = "/tsplist", method = RequestMethod.GET)
    @JsonIgnore
    public ResponseEntity<List<TspInfo>> getAllTsp() {
        List<TspInfo> list = iTspInfoService.getAllTspInfo();
        return new ResponseEntity<List<TspInfo>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/tsplist/{id}", method = RequestMethod.GET)
    public ResponseEntity<TspInfo> getTspById(@PathVariable("id") Integer id) {
        TspInfo tspInfo = iTspInfoService.getTspById(id);
        return new ResponseEntity<TspInfo>(tspInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/tsplist", method = RequestMethod.POST)
    public ResponseEntity<Void> addPTsp(@RequestBody TspInfo tspInfo, UriComponentsBuilder builder) {
        boolean flag = iTspInfoService.addTsp(tspInfo);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/tsplist/{id}").buildAndExpand(tspInfo.getTspId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tsplist/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TspInfo> updateTsp(@RequestBody TspInfo tspInfo) {
        iTspInfoService.updateTsp(tspInfo);
        return new ResponseEntity<TspInfo>(tspInfo, HttpStatus.OK);
    }

    @RequestMapping(value = "/tsplist/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTsp(@PathVariable("id") Integer id) {
        iTspInfoService.deleteTsp(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
