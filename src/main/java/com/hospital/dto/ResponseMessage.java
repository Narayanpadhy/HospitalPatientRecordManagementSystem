package com.hospital.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage
{
	private Integer statusCode;
	private String Status;
	private String Message;
	private Object data;
	private List<?> list;
	
	public ResponseMessage(Integer statusCode, String status, String message) {
		this.statusCode = statusCode;
		Status = status;
		Message = message;
	}

	public ResponseMessage(Integer statusCode, String status, String message, Object data) {
		this.statusCode = statusCode;
		Status = status;
		Message = message;
		this.data = data;
	}

	public ResponseMessage(Integer statusCode, String status, String message, List<?> list) {
		this.statusCode = statusCode;
		Status = status;
		Message = message;
		this.list = list;
	}
	
}
