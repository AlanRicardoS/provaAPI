package com.example.provaAPI.response;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import com.example.provaAPI.enums.ErrorType;
import com.example.provaAPI.enums.SuccessMessage;
import com.example.provaAPI.utils.JsonUtils;
import com.example.provaAPI.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

	@JsonInclude(Include.NON_NULL)
	HttpServletRequest request;
	
	@JsonInclude(Include.NON_NULL)
	private ErrorType errorType;
	
	@JsonIgnore
	private String requestId;
	
	@JsonInclude(Include.NON_NULL)
	private String path;
	
	@JsonInclude(Include.NON_NULL)
	private SuccessMessage successMessage;

    @JsonInclude(Include.NON_NULL)
    private Integer code;

    @JsonInclude(Include.NON_NULL)
    private String messageDetail;
    
    @JsonInclude(Include.NON_NULL)
    private String message;

    @JsonInclude(Include.NON_NULL)
    private HttpStatus httpStatus;
    
    @JsonInclude(Include.NON_NULL)
    private int httpCode;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("link")
    private HttpStatusReference apiReferences;
    
    @JsonInclude(Include.NON_NULL)
    @JsonProperty("error")
    private ErrorResponse error;
    
public ApiResponse() {}
	
	public ApiResponse(ErrorType errorType, HttpStatus httpStatus) {
        this.requestId = Utils.generateId();
        this.code = errorType.getCode();
        this.message = errorType.getDesc();
        this.httpCode = httpStatus.value();
        this.httpStatus = httpStatus;
    }
	
	public ApiResponse(SuccessMessage successMessage, int httpCode) {
		this.requestId = Utils.generateId();
        this.code = successMessage.getCode();
        this.message = successMessage.getDesc();
        this.httpCode = httpCode;
    }
	
	public ApiResponse(SuccessMessage successMessage, HttpStatus httpStatus) {
        this.requestId = Utils.generateId();
        this.code = successMessage.getCode();
        this.message = successMessage.getDesc();
        this.httpStatus = httpStatus;
        this.httpCode = httpStatus.value();
    }
	
	public ApiResponse(SuccessMessage successMessage,
                       String amount,
                       String transactionId) {
		this.requestId = Utils.generateId();
		this.code = successMessage.getCode();
		this.message = successMessage.getDesc();
	}

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SuccessMessage getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(SuccessMessage successMessage) {
        this.successMessage = successMessage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
	
	public String getMessageDetail() {
		return messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public HttpStatusReference getApiReferences() {
		return apiReferences;
	}

	public void setApiReferences(HttpStatusReference apiReferences) {
		this.apiReferences = apiReferences;
	}
	
	public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }

    @Override
	public String toString() {
        return JsonUtils.parseToJsonString(this); 
	}
}
