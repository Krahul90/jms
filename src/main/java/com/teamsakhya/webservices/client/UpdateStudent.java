package com.teamsakhya.webservices.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.teamsakhya.webservices.client.dto.ResponseGenerator;
import com.teamsakhya.webservices.client.dto.StudentBean;

public class UpdateStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentBean student = new StudentBean();
		student.setRegno(101);
		student.setName("prabhakar");
		student.setAddress("nagpur");
		student.setMarks(601);
		student.setGender("male");
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8081/webservices/api/student/update");
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).put(Entity.json(student));
		System.out.println(response.readEntity(String.class));
		//System.out.println(response.readEntity(ResponseGenerator.class));
		
		
	}

}
