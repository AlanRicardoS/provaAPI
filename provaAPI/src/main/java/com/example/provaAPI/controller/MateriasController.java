package com.example.provaAPI.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.provaAPI.bussiness.ProvaApiBussiness;
import com.example.provaAPI.response.MateriasResponse;
import com.example.provaAPI.service.MateriasService;
import com.example.provaAPI.vo.MateriasVO;

@RestController
@RequestMapping("/materias")
public class MateriasController {
    private final MateriasService materiasService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MateriasController.class);

    @Autowired
    ProvaApiBussiness provaApiBussiness;
    
    @Autowired
    public MateriasController(final MateriasService materiasService) {
        this.materiasService = materiasService;
    }

    @GetMapping(produces = {"application/json;charset=utf-8"})
    public ResponseEntity<MateriasResponse> getAllMaterias(HttpServletRequest request, 
            											   HttpServletResponse response) {
    	
        LOGGER.info("Buscando todas as matérias ...");
        
        MateriasResponse apiResponse = provaApiBussiness.getAllMaterias();
    	
        return new ResponseEntity<MateriasResponse>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<MateriasVO> create(@RequestBody MateriasVO materiasVO) {
        MateriasVO materias = materiasService.createMaterias(materiasVO);
        return new ResponseEntity<>(materias, HttpStatus.CREATED);
    }
}
