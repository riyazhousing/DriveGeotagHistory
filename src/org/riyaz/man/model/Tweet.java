package org.riyaz.man.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Tweet {
	
	@Id
	private int Id;
	private String body;
	private String username;
	private String location;
	private Date date;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Tweet(int Id, String body, String username, String location, Date date)
	{
		setId(Id);
		setBody(body);
		setUsername(username);
		setDate(date);
		setLocation(location);
	}
	public Tweet(){}

}
