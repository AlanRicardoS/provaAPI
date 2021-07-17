package com.example.provaAPI.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.example.provaAPI.constants.Constants;

public class DateUtils {

	private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
    
	public static LocalDateTime timestampValidation(String timestamp){
        DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.TIMESTAMP_FORMAT);
        return LocalDateTime.parse(timestamp, format);
	}
	
	public static LocalDateTime timestampPesquisaValidation(String timestamp){
        DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.TIMESTAMP_PESQUISA_FORMAT);
        return LocalDateTime.parse(timestamp, format);
    }

	public static LocalDate dateValidation(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        return LocalDate.parse(date, format);
	}
		
	public static LocalDate getLocalDateOf(String date) {
		return dateValidation(date);
	}
	
	public static boolean invalidDataIniAndDataFimMaior(String dateIni, String dateFim) {
	    DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.TIMESTAMP_PESQUISA_FORMAT);
        
	    LocalDateTime dataIni = LocalDateTime.parse(dateIni, format);
	    LocalDateTime dataFim = LocalDateTime.parse(dateFim, format);
	    
	    boolean result;
	    
	    if(dataIni.isAfter(dataFim)) {
	        result = true;
	    } else {
	        result = false;
	    }
	    
	    return result;
	}
	
	public static boolean invalidDataIniAndDataFimPeriodo30dias(String dateIni, String dateFim) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(Constants.TIMESTAMP_PESQUISA_FORMAT);
        
        LocalDateTime dataIni = LocalDateTime.parse(dateIni, format);
        LocalDateTime dataFim = LocalDateTime.parse(dateFim, format);
        
        boolean result;
        
        if(ChronoUnit.DAYS.between(dataIni, dataFim) > Long.valueOf(30)) {
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }
	
}
