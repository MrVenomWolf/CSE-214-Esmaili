/**
* Fully-documented class named folder where this class represents an email folder 
* Also it will handle all of the logic for adding and removing emails.
* This class should have a constructor, mutator and accessor methods for each instance variable. 
*
* @author: Anubrota Majumdar
* @Due: 08/12/2022
* @ID: 114586887
* @Assignment: HW4 Summer 2022
* @Recitation: R30
* @email: anubrota.majumdar@stonybrook.edu
*/


import java.io.Serializable;
import java.util.GregorianCalendar;

public class Email implements Serializable {
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private GregorianCalendar timestamp;

	public Email() 
	{

	}

	public Email(String to, String subject, String body)
	{
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	public String getTo() 
	{
		return to;
	}

	public void setTo(String to) 
	{
		this.to = to;
	}

	public String getCc() 
	{
		return cc;
	}

	public void setCc(String cc) 
	{
		this.cc = cc;
	}

	public String getBcc()
	{
		return bcc;
	}

	public void setBcc(String bcc) 
	{
		this.bcc = bcc;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String getBody() 
	{
		return body;
	}

	public void setBody(String body) 
	{
		this.body = body;
	}

	public GregorianCalendar getTimestamp() 
	{
		return timestamp;
	}

	public void setTimestamp(GregorianCalendar timestamp) 
	{
		this.timestamp = timestamp;
	}

}
