package it.epicode.esercizi.cinema.login.model;

public class SignUpResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SignUpResponse(String message) {
		super();
		this.message = message;
	}
	
	
}
