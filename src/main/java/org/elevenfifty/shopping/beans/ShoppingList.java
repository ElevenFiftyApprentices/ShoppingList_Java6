package org.elevenfifty.shopping.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.elevenfifty.shopping.DateTimeOffset;

public class ShoppingList {
	//adding in variables per the TDD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int userId;
	private String name;
	private String color;
	//created custom class to create a DateTimeOffset since it is a SQL only type of variable
	private DateTimeOffset createdUtc;
	private DateTimeOffset modifiedUtc;

	//getters setters and hash coding and equals for variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public DateTimeOffset getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(DateTimeOffset createdUtc) {
		this.createdUtc = createdUtc;
	}

	public DateTimeOffset getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(DateTimeOffset modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((createdUtc == null) ? 0 : createdUtc.hashCode());
		result = prime * result + id;
		result = prime * result + ((modifiedUtc == null) ? 0 : modifiedUtc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingList other = (ShoppingList) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (createdUtc == null) {
			if (other.createdUtc != null)
				return false;
		} else if (!createdUtc.equals(other.createdUtc))
			return false;
		if (id != other.id)
			return false;
		if (modifiedUtc == null) {
			if (other.modifiedUtc != null)
				return false;
		} else if (!modifiedUtc.equals(other.modifiedUtc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
