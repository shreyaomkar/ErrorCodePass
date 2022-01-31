package com.xml.example.Marshal_XML;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.xml.example.data.ReceivePojo;
import com.xml.example.data.Request_State;

/**
 * Hello world!
 *
 */
public class App 
{
	//private static final String Receive_XML = "C:\\Users\\shreya.patil\\Project\\Marshal_XML\\Sample.xml";
	 
	  public static void main(String[] args) throws JAXBException, IOException
	  {
		Date d1 = new Date(2000, 11, 21);
		ReceivePojo pojo=new ReceivePojo();
		pojo.setClient("MVD");
		pojo.setFileID("MVD00000072");
		pojo.setDate(d1);
		Request_State state=new Request_State();
		state.setDiscount_RequestID(50);
		state.setStatus(1);
		String str=ValidateXML.main("Sample.xml", "Sample.xsd");
		state.setError_Code(str);
		pojo.addRequest(state);
	 
		// create JAXB context and instantiate marshaller
		// here bookStore class is container , which contains Book
		JAXBContext context = JAXBContext.newInstance(ReceivePojo.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
		// Write to System.out
		m.marshal(pojo, System.out);
		File f=new File("C:\\Users\\shreya.patil\\Project\\ErrorCodePass\\Sample.xml");
		if(f.exists())
		{
		  f.delete();
		  try
		  {
		    f.createNewFile();
		  }
		  catch(IOException e)
		  {
		    e.printStackTrace();
		  }
	    }
		// Write to File
		m.marshal(pojo, f);
		
		//ValidateXML.main("Sample.xml", "Sample.xsd");
	  }
	  
}
