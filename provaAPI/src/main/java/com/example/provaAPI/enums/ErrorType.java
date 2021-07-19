package com.example.provaAPI.enums;

import java.net.HttpURLConnection;

public enum ErrorType {

	FIELD_VALIDATION_(1, "Campo obrigatório não encontrado"),
	FIELD_VALIDATION_NUMERIC_FIELD_INVALID(2, "O campo numérico é inválido"),
	FIELD_VALIDATION_NAME_INVALID(3, "O nome é inválido"),
	MATERIA_NOT_FOUND(4, "Matéria não encontrada."),

	HTTP_CLIENT_TIMEOUT(HttpURLConnection.HTTP_CLIENT_TIMEOUT, "Request timeout"),
	HTTP_UNSUPPORTED_TYPE(HttpURLConnection.HTTP_UNSUPPORTED_TYPE, "Unsupported media type"),
	HTTP_UNAUTHORIZED(HttpURLConnection.HTTP_UNAUTHORIZED, "Unauthorized access"),
	HTTP_RESPONSE_CUSTOMER_BALANCE_DENIED(8, "Customer balance request denied"),
    HTTP_RESPONSE_ALUNO_DENIED(8, "Aluno request denied"),
    HTTP_RESPONSE_MATERIA_DENIED(8, "Materia request denied");
	
    public final Integer code;
    private final String desc;
    
    private ErrorType(Integer c, String s) {
        this.code = c;
        this.desc = s;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    
    public String getEnumName() {
        return name();
    }
    
    public static ErrorType getFromCode(Integer code) {
        if (code == null || code == 0) {
            return null;
        }

        for (ErrorType value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
