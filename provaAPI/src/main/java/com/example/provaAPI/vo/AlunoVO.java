package com.example.provaAPI.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.example.provaAPI.model.Aluno;

public class AlunoVO extends RepresentationModel<AlunoVO> implements Serializable {
    private Long id;
    private String nome;
    private Integer idade;
    private String email;
    private List<MateriasVO> materias = new ArrayList<>();

    public static AlunoVO create (Aluno aluno){
        return new ModelMapper().map(aluno, AlunoVO.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(final Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<MateriasVO> getMaterias() {
        return materias;
    }

    public void setMaterias(final List<MateriasVO> materias) {
        this.materias = materias;
    }
}
