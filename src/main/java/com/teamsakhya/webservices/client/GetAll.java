package com.teamsakhya.webservices.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class GetAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.
				target("http://localhost:8081/webservices/api/student/getAll");
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.readEntity(String.class));
		//System.out.println(response.readEntity(ResponseGenerator.class));
		
	
	}

}
