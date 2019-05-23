package com.java.test;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/resteasy/")
public class RESTeasy {

	@GET
	@Path("login/{name}")
	@Produces("application/json")
	public String getLogin(@PathParam("name") String name) {
		return name + "-----123";
	}
	
	
	@POST
	@Path("login")
	@Produces("application/json")
	public String addLogin(String name) {
		System.out.println("ADD......");
		return "add success";
	}
	
	
	@PUT
	@Path("login")
	@Produces("application/json")
	public String updateLogin(String name) {
		System.out.println("UPDATE......");
		return "update success";
	}
	
	@DELETE
	@Path("login")
	@Produces("application/json")
	public String deleteLogin(String name) {
		System.out.println("DELETE......");
		return "delete success";
	}
}
