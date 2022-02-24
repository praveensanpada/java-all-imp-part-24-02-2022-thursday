package com.example.demo.dto;



public class JwtTokenDTO {
	String token;

	/**
	 * @param token
	 */
	public JwtTokenDTO() {
	}

	public JwtTokenDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
