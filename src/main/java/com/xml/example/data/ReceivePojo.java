package com.xml.example.data;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Receive_Request")
@XmlAccessorType (XmlAccessType.FIELD)
public class ReceivePojo
{
	private String Client;
	private String FileID;
	@XmlElement(name="Date")
	private Date date=new Date();
	@XmlElementWrapper(name = "Request_States") 
	@XmlElement(name = "Request_State")
	private ArrayList<Request_State> requestList;
	
	public ReceivePojo() {}

	public ReceivePojo(String client, String fileID) 
	{
		Client = client;
		FileID = fileID;
	}

	public String getClient() 
	{
		return Client;
	}

	public void setClient(String client) 
	{
		Client = client;
	}

	public String getFileID() 
	{
		return FileID;
	}

	public void setFileID(String fileID)
	{
		FileID = fileID;
	}

	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public void setRequestList(ArrayList<Request_State> requestList) 
	{
		this.requestList = requestList;
	}

	public ArrayList<Request_State> getRequestList() 
	{
		return requestList;
	}

	public void addRequest(Request_State state)
	{
	  	try 
	  	{
	  	  if (requestList == null) 
	  	  {
	  		requestList = new ArrayList<Request_State>();
		  }
	  	  	requestList.add(state);
	 
		}
	  	catch (Exception e) 
	  	{
	  		e.printStackTrace();
			}
	}
}
