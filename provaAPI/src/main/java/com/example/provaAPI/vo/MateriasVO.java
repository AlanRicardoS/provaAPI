package com.example.provaAPI.vo;

import com.example.provaAPI.model.Materias;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @author Alan Ricardo
 */
public class MateriasVO extends RepresentationModel<MateriasVO> implements Serializable {
    private Long id;
    private String nome;

    public static MateriasVO create(Materias materias) {
        return new ModelMapper().map(materias, MateriasVO.class);
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
}
