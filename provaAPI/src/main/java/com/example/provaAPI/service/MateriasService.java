package com.example.provaAPI.service;

import com.example.provaAPI.model.Materias;
import com.example.provaAPI.repository.MateriasRepository;
import com.example.provaAPI.vo.MateriasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alan Ricardo
 */
@Service
public class MateriasService {
    private final MateriasRepository materiasRepository;

    @Autowired
    public MateriasService(final MateriasRepository materiasRepository) {
        this.materiasRepository = materiasRepository;
    }

    public MateriasVO createMaterias(MateriasVO materiasVO) {
        return MateriasVO.create(materiasRepository.save(Materias.create(materiasVO)));
    }

    public List<MateriasVO> findAll() {
        var materias = materiasRepository.findAll();
        return materias.stream().map(materia -> convertToMateriaVO(materia)).collect(Collectors.toList());
    }

    private MateriasVO convertToMateriaVO(Materias materias) {
        return MateriasVO.create(materias);
    }
}
