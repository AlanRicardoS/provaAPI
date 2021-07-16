package com.example.provaAPI.model;

import com.example.provaAPI.vo.AlunoVO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Ricardo
 */
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String nome;

    @Column(nullable = false, length = 10)
    private Integer idade;

    @Column(nullable = false, length = 255)
    private String email;

    @OneToMany
    private List<Materias> materias = new ArrayList<>();

    public static Aluno create(AlunoVO alunoVO){
        return new ModelMapper().map(alunoVO, Aluno.class);
    }

    public Aluno() {
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

    public List<Materias> getMaterias() {
        return materias;
    }

    public void setMaterias(final List<Materias> materias) {
        this.materias = materias;
    }
}
