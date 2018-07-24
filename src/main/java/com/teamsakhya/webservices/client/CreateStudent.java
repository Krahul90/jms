package com.teamsakhya.webservices.client;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.teamsakhya.webservices.client.dto.ResponseGenerator;
import com.teamsakhya.webservices.client.dto.StudentBean;

/**
 * Hello world!
 *
 */
    public class CreateStudent {
    	
    	private static final String QUEUE_NAME = "Rahul";	//--> for Queue
    	private static final String URL = "tcp://localhost:61616";
    	
	public static void main(String[] args) throws JMSException {
		StudentBean student = new StudentBean();
		student.setRegno(102);
		student.setName("rahul");
		student.setAddress("bangalore");
		student.setMarks(01);
		student.setGender("male");

	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target("http://localhost:8081/webservices/api/student/add");
	Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(student));
	ResponseGenerator respon = response.readEntity(ResponseGenerator.class);
		
	
	
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
	Connection connection = connectionFactory.createConnection();
	Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	Destination destination = session.createQueue(QUEUE_NAME);
	TextMessage message = session.createTextMessage("status code = " +respon.getStatusCode()
											   + " | messgae = " + respon.getMessage() 
							
											   + " | Description = " + respon.getDescription());
	MessageProducer messageProducer = session.createProducer(destination);
	messageProducer.send(message);
	
	session.close();
	connection.close();

	
	
	
		// System.out.println(response.readEntity(ResponseGenerator.class));

	}
}
