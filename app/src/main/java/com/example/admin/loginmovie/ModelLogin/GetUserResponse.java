package com.example.admin.loginmovie.ModelLogin;

import com.google.gson.annotations.SerializedName;


public class GetUserResponse{

	@SerializedName("name")
	String name;
	@SerializedName("email")
	String email;

	public String getName() {
		return name;
	}

	public void setName(String nama) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}