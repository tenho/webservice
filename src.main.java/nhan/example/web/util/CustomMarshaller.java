package nhan.example.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class CustomMarshaller {
    
    //Converts Object to XML file
    public void objectToXML(Object graph, OutputStream out) throws IOException, XmlMappingException {
    	
    	Marshaller marshaller = getCastorMarshaller();
    	marshaller.marshal(graph, new StreamResult(out));
    }
    
    //Converts XML to Java Object
    public Object xmlToObject(InputStream in) throws IOException, XmlMappingException {
    	
    	Unmarshaller unmarshaller = getCastorMarshaller();
    	return unmarshaller.unmarshal(new StreamSource(in));
    }
    
	private Jaxb2Marshaller getCastorMarshaller() {
	  Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
	  jaxb2Marshaller.setPackagesToScan("ws.wsdl");
	  jaxb2Marshaller.setContextPath("ws.wsdl");
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("jaxb.formatted.output", true);
	  jaxb2Marshaller.setMarshallerProperties(map);
          return jaxb2Marshaller;
	}
}
