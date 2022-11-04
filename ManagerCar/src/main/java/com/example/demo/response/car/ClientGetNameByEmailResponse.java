package com.example.demo.response.car;

public class ClientGetNameByEmailResponse {
  private String name;
  
  public ClientGetNameByEmailResponse() {}
  
  public ClientGetNameByEmailResponse(String name) {
	  this.name = name;
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  public String getName() {
	  return name;
  }
}