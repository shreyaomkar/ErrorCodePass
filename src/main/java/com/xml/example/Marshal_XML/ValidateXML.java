package com.xml.example.Marshal_XML;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidateXML
{
  public static String main(String xmlFile,String xsdFile) 
  {
    boolean isValid=false;
    final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
    
    try 
    {
        //isValid=true;
        //System.out.println("Hi");
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(xsdFile));
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new ErrorHandler()
        {
              @Override
              public void warning(SAXParseException exception) throws SAXException
              {
                exceptions.add(exception);
              }

              @Override
              public void fatalError(SAXParseException exception) throws SAXException
              {
                exceptions.add(exception);
              }

              @Override
              public void error(SAXParseException exception) throws SAXException
              {
                exceptions.add(exception);
              }

        });
        validator.validate(new StreamSource(new File(xmlFile)));
        
        
    } 
    catch (IOException e) 
    {
        isValid=false;
        System.out.println("Exception: " + e.getMessage());
        //return false;
    }
    catch (SAXException e1)
    {
        isValid=false;
            exceptions.forEach(e->
            System.out.println("Error"+e.getLineNumber()+e.getMessage()));
            //return false;
    }
    
    if(exceptions.size()>0)
    {
        System.out.println("File is inValid");
        StringBuilder build=new StringBuilder();
        
       // build.append(exceptions.forEach(e->e.getLineNumber()+e.getMessage()));
        
       exceptions.forEach(e->build.append(e.getLineNumber()+e.getMessage()));
       System.out.println(build.toString()); 
        return build.toString();
    }
    else
    {
        return "File is Valid";
      //System.out.println("File is Valid");
    }
  }

}
