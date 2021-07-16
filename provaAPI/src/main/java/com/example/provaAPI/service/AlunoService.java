package com.example.provaAPI.service;

import com.example.provaAPI.model.Aluno;
import com.example.provaAPI.model.Materias;
import com.example.provaAPI.repository.AlunoRepository;
import com.example.provaAPI.vo.AlunoVO;
import com.example.provaAPI.vo.MateriasVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alan Ricardo
 */
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(final AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoVO> findAll() {
        var alunos = alunoRepository.findAll();
         return alunos.stream().map(aluno -> convertToUserDTO(aluno)).collect(Collectors.toList());
    }

    private AlunoVO convertToUserDTO(Aluno aluno) {
        return AlunoVO.create(aluno);
    }

    public AlunoVO findById(Long id) {
        var aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            return AlunoVO.create(aluno.get());
        } else {
            return null;
        }
    }

    public Aluno findByName(String name) {
        var aluno = alunoRepository.findByNome(name);
        if (aluno.isPresent()) {
            return aluno.get();
        } else {
            return null;
        }
    }

    public void setMateriaOnAluno(MateriasVO materiasVO, Long id) {
        var aluno = findById(id);
        aluno.getMaterias().add(Materias.create(materiasVO));
        alunoRepository.save(Aluno.create(aluno));
    }
    public AlunoVO createAluno(AlunoVO alunoVO){
        return AlunoVO.create(alunoRepository.save(Aluno.create(alunoVO)));
    }
}
