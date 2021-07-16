package com.example.provaAPI.model;

import com.example.provaAPI.vo.MateriasVO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alan Ricardo
 */
@Entity
public class Materias implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String nome;

    public static Materias create(MateriasVO materiasVO){
        return new ModelMapper().map(materiasVO, Materias.class);
    }

    public Materias() {
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
