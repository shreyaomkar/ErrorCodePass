package com.xml.example.data;

public class Request_State 
{
	private int Discount_RequestID;
	private int Status;
	private String Error_Code;
	
	public Request_State() {}

	public Request_State(int discount_RequestID, int status, String error_Code) 
	{
		Discount_RequestID = discount_RequestID;
		Status = status;
		Error_Code = error_Code;
	}

	public int getDiscount_RequestID() 
	{
		return Discount_RequestID;
	}

	public void setDiscount_RequestID(int discount_RequestID) 
	{
		Discount_RequestID = discount_RequestID;
	}

	public int getStatus() 
	{
		return Status;
	}

	public void setStatus(int status)
	{
		Status = status;
	}

	public String getError_Code() 
	{
		return Error_Code;
	}

	public void setError_Code(String error_Code) 
	{
		Error_Code = error_Code;
	}

	@Override
	public String toString() 
	{
		return "Request_State [Discount_RequestID=" + Discount_RequestID + ", Status=" + Status + ", Error_Code="
				+ Error_Code + "]";
	}
	
}
