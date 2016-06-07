package nhan.example.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import ws.wsdl.FindAllUsers;
import ws.wsdl.FindAllUsersResponse;
import ws.wsdl.FindById;
import ws.wsdl.FindByIdResponse;

public class UserWsTest extends WebServiceGatewaySupport {
	
	public UserWsTest() {
		super();
	}
	
	public FindByIdResponse findById(long id) {
				
		FindById request = new FindById();
		request.setArg0(id);
		WebServiceTemplate client = getWebServiceTemplate();		
		FindByIdResponse response = (FindByIdResponse) client.marshalSendAndReceive(request,
				new SoapActionCallback("http://service.jaxws.ws.example.nhan/UserWS/findByIdRequest"));
		try {
			client.getMarshaller().marshal(response, new StreamResult(System.out));
			
		} catch (XmlMappingException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return response;
	}
	
	public FindAllUsersResponse findAllUsers() {
		
		FindAllUsers request = new FindAllUsers();
		WebServiceTemplate client = getWebServiceTemplate();		
		FindAllUsersResponse response = (FindAllUsersResponse) client.marshalSendAndReceive(request,
				new SoapActionCallback("http://service.jaxws.ws.example.nhan/UserWS/findAllUsersRequest"));
		try {
			client.getMarshaller().marshal(response, new StreamResult(System.out));
			
		} catch (XmlMappingException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return response;
	}
	
	public static void main(String args[]){
		UserWsTest test = new UserWsTest();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		test.setDefaultUri("http://localhost:8080/webservice/service/user");
		marshaller.setContextPath("ws.wsdl");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(Marshaller.JAXB_FORMATTED_OUTPUT , true);
		marshaller.setMarshallerProperties(map);
		  
		test.setMarshaller(marshaller);
		test.setUnmarshaller(marshaller);
		
		test.findById(1);
		
		test.findAllUsers();
    }
	
	
}