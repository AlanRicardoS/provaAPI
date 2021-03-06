package com.example.provaAPI.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.UUID;

public class Utils {

	private Utils() {
        throw new IllegalStateException("Utility class");
    }
    
	public static String generateId() {
		return UUID.randomUUID().toString();
	}

	public static int calculateTotalOfPages(long value, long divisor) {
		return (int) (Math.ceil(value + divisor - 1d) / divisor);
	}

	public static boolean hasOnlyNumbers(String charSequence) {
		int comprimeto = charSequence.length() - 1;
		return charSequence.matches("^[\\-\\+0-9]{1}[0-9]{" + comprimeto + "}");

	}

	public static boolean fieldOutOfRange(String value) {
		return new BigInteger(value).compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0
				|| new BigInteger(value).compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0;
	}

	public static boolean decimalFieldOutOfRange(String value) {
		return new BigDecimal(value).compareTo(BigDecimal.valueOf(Long.MIN_VALUE)) < 0
				|| new BigDecimal(value).compareTo(BigDecimal.valueOf(Long.MAX_VALUE)) > 0;
	}

	public static boolean invalidTimestampFormat(String timestamp) {
		try {
			DateUtils.timestampValidation(timestamp);
			return false;
		} catch (DateTimeParseException dateTimeParseException) {
			return true;
		}
	}
	
	public static boolean invalidTimestamPesquisaFormat(String timestamp) {
        try {
            DateUtils.timestampPesquisaValidation(timestamp);
            return false;
        } catch (DateTimeParseException dateTimeParseException) {
            return true;
        }
    }

	public static boolean invalidDateIniAndDateFimMaior(String dateIni, String dateFim) {
        try {
            return DateUtils.invalidDataIniAndDataFimMaior(dateIni, dateFim);
        } catch (DateTimeParseException dateTimeParseException) {
            return true;
        }
    }
	
	public static boolean invalidDateIniAndDateFimPeriodo30dias(String dateIni, String dateFim) {
        try {
            return DateUtils.invalidDataIniAndDataFimPeriodo30dias(dateIni, dateFim);
        } catch (DateTimeParseException dateTimeParseException) {
            return true;
        }
    }
	
	public static boolean dateValidation(String timestamp) {
		try {
			DateUtils.dateValidation(timestamp);
			return false;
		} catch (DateTimeParseException dateTimeParseException) {
			return true;
		}
	}

	public static boolean getLocalDateOf(String timestamp) {
		try {
			DateUtils.getLocalDateOf(timestamp);
			return false;
		} catch (DateTimeParseException dateTimeParseException) {
			return true;
		}
	}

	public static boolean stringLengthOutOfRange(int currentLength, int expectedLength) {
		return currentLength > expectedLength;
	}

	public static boolean invalidDoubleField(String field) {
		try {
			Double.parseDouble(field);
			return false;
		} catch (NumberFormatException numberException) {
			return true;
		}
	}
	/*
	public static boolean anyRequiredFieldIsNullOrEmpty(List<String> fields) {
		if(fields.isEmpty()) {
			return true;
		}		
		for (String field : fields) {
			if (StringUtils.isBlank(field)) {
				return true;
			}
		}
		return false;
	}
	*/
	public static boolean anyTimeStampFieldIsInvalid(List<String> fields) {
		if(fields.isEmpty()) {
			return true;
		}
		
		for (String field : fields) {
			if (invalidTimestampFormat(field)) {
				return true;
			}
		}
		return false;
	}

	public static boolean anyNumericFieldIsInvalid(List<String> fields) {
		if (fields.isEmpty()) {
			return true;
		}		
		for (String field : fields) {
			if (!hasOnlyNumbers(field)) {
				return true;
			}
		}
		return false;
	}

	public static boolean anyDoubleFieldIsInvalid(List<String> fields) {
		if (fields.isEmpty()) {
			return true;
		}
		for (String field : fields) {
			if (invalidDoubleField(field)) {
				return true;
			}
		}

		return false;
	}
	
}
