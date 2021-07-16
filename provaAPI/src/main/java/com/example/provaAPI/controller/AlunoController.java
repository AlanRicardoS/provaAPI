package com.example.provaAPI.controller;

import com.example.provaAPI.service.AlunoService;
import com.example.provaAPI.vo.AlunoVO;
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
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(final AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<AlunoVO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(alunoService.findById(id), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<AlunoVO>> findAll() {
        return new ResponseEntity<>(alunoService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<AlunoVO> create(@RequestBody AlunoVO alunoVO) {
        var alunoReturn = alunoService.createAluno(alunoVO);
        return new ResponseEntity<>(alunoReturn, HttpStatus.CREATED);
    }
    @PostMapping( value ="/materia/{id}", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<?> setMateriaOnAluno(@RequestBody MateriasVO materiasVO, 
    									       @PathVariable("id") Long id) {
        alunoService.setMateriaOnAluno(materiasVO, id);
        return ResponseEntity.ok().build();
    }
}
