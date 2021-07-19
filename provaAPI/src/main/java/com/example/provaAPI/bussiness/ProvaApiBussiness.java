package com.example.provaAPI.bussiness;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.provaAPI.enums.ErrorType;
import com.example.provaAPI.enums.SuccessMessage;
import com.example.provaAPI.response.MateriasResponse;
import com.example.provaAPI.service.MateriasService;
import com.example.provaAPI.vo.MateriasVO;

public class ProvaApiBussiness {
	
	MateriasResponse materiasResponse;
	
	MateriasService materiasService;

	
	// Inicio MateriasFindAll
    public MateriasResponse getAllMaterias() {

    	materiasResponse = null;
    	
    	List<MateriasVO> listaDeMaterias = materiasService.findAll();
    	
    	if(listaDeMaterias.isEmpty()) {
            return new MateriasResponse(ErrorType.MATERIA_NOT_FOUND, HttpStatus.NOT_FOUND);
    	} else {
    		
    		materiasResponse = new MateriasResponse(SuccessMessage.GET_MATERIA,
    												listaDeMaterias,
    												HttpStatus.OK);
    	}
    	
    	return materiasResponse;
    	
    }

}
