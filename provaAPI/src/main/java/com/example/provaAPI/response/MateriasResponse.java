package com.example.provaAPI.response;

import org.springframework.http.HttpStatus;

import com.example.provaAPI.enums.ErrorType;
import com.example.provaAPI.enums.SuccessMessage;
import com.example.provaAPI.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MateriasResponse extends ApiResponse{

	@JsonInclude(Include.NON_NULL)
	private Long id;

	@JsonInclude(Include.NON_NULL)
    private String nome;

	public MateriasResponse() {}
	
	public MateriasResponse(SuccessMessage successMessage,
					        Long id,
					        String nome,
					        HttpStatus httpStatus) {

		this.setMessage(successMessage.getDesc());
		this.setCode(successMessage.getCode());
		this.setHttpCode(httpStatus.value());
		this.setHttpStatus(httpStatus);
	}
	
	public MateriasResponse(ErrorType errorType, HttpStatus httpStatus) {
        super(errorType, httpStatus);
    }
    
    public MateriasResponse(SuccessMessage successMessage, int httpcode) {
        super(successMessage, httpcode);
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
    
    @Override
    public String toString() {
        return JsonUtils.parseToJsonString(this); 
    }
}
