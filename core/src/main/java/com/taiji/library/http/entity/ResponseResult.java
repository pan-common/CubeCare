package com.taiji.library.http.entity;

public class ResponseResult {
	
	private String code;//标识符：500 服务错误  200 成功  300 失败
	
	private String result;
	
	private String message;

	public ResponseResult(String code, String result, String message) {
		super();
		this.code = code;
		this.result = result;
		this.message = message;
	}

	public ResponseResult() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseResult [code=" + code + ", result=" + result
				+ ", message=" + message + "]";
	}
	

}
