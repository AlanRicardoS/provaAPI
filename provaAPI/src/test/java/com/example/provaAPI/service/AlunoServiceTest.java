package com.example.provaAPI.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import com.example.provaAPI.repository.AlunoRepository;
import com.example.provaAPI.vo.AlunoVO;
import com.example.provaAPI.vo.MateriasVO;

public class AlunoServiceTest {
	
	private AlunoService alunoService;
	
	AlunoVO alunoVO = new AlunoVO();
	MateriasVO materiasVO = new MateriasVO();
	
	@Mock
    private AlunoRepository alunoRepository;
	
	ArrayList<Object> aluno = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		
		alunoVO.setId(Long.parseLong("1"));
		alunoVO.setEmail("alan@gmail.com");
		alunoVO.setIdade(19);
		alunoVO.setNome("Alan");
		
		aluno.add(alunoVO);

		materiasVO.setId(Long.parseLong("1"));
		materiasVO.setNome("Matematica");
		
		List<MateriasVO> materias = new ArrayList<>();
		materias.add(materiasVO);
		
		alunoVO.setMaterias(materias);
		 
	}
	/*
	@Test
    public void alunoFindAllTest() {
		
		alunoService.findAll();
		List alunoList = new ArrayList<>();
		alunoList.add(alunoVO);

		when(alunoRepository.findAll()).thenReturn(alunoList);
	}	
	*/		
	/*
	@Test
	public void alunoFindByIdTest() {
		
		when(alunoRepository.findById(Long.parseLong("1")).get()).thenReturn(aluno);
		//when(alunoService.findById(Long.parseLong("1")));
	}
	*/
}
