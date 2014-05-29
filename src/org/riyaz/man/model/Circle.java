package org.riyaz.man.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Circle {

	@Id
	private int id;
	private String Name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Circle(int circleId, String Name)
	{
		setId(circleId);
		setName(Name);
	}
	public Circle(){}
}
