package com.example.provaAPI.enums;

public enum SuccessMessage {

	GET_ALUNO(0, "O aluno foi encontrado com sucesso"),
	INSERT_ALUNO(0, "O aluno foi inserido com sucesso"),
	DELETED_ALUNO(0, "O aluno foi deletado com sucesso"),
	UPDATE_ALUNO(0, "O aluno foi atualizado com sucesso"),
	GET_MATERIA(0, "A matéria foi encontrado com sucesso");
	
	private String desc;
	private int code;
    
    private SuccessMessage(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public int getCode() {
    	return code;
    }
    
}
