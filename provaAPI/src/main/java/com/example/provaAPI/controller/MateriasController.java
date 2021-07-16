package com.example.provaAPI.controller;

import com.example.provaAPI.service.MateriasService;
import com.example.provaAPI.vo.MateriasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alan Ricardo
 */
@RestController
@RequestMapping("/materias")
public class MateriasController {
    private final MateriasService materiasService;

    @Autowired
    public MateriasController(final MateriasService materiasService) {
        this.materiasService = materiasService;
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<MateriasVO>> findAll() {
        return new ResponseEntity<>(materiasService.findAll(), HttpStatus.OK);
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<MateriasVO> create(@RequestBody MateriasVO materiasVO) {
        MateriasVO materias = materiasService.createMaterias(materiasVO);
        return new ResponseEntity<>(materias, HttpStatus.CREATED);
    }
}
