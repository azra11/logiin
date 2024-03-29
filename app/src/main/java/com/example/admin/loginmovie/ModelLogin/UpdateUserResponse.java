package com.example.admin.loginmovie.ModelLogin;


import com.google.gson.annotations.SerializedName;

public class UpdateUserResponse{

	@SerializedName("password")
	private String password;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("__v")
	private int V;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("_id")
	private String id;

	@SerializedName("email")
	private String email;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"UpdateUserResponse{" + 
			"password = '" + password + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",__v = '" + V + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",_id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}