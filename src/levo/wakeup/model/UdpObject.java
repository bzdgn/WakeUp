package levo.wakeup.model;

public class UdpObject implements java.io.Serializable
{
	private String name;
	private String message;
	
	//No argument default constructor
	public UdpObject() {}
	
	public UdpObject(String name, String message)
	{
		this.name = name;
		this.message = message;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}	
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
