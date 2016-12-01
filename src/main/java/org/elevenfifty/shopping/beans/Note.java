package org.elevenfifty.shopping.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "notes")
public class Note {
	//adding in variables per the TDD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int itemId;
	private String body;
	//created custom class to create a DateTimeOffset since it is a SQL only type of variable
	private Date createdUtc;
	private Date modifiedUtc;

	//getters setters and hash coding and equals for variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShoppingListItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	public Date getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(Date createdUtc) {
		this.createdUtc = createdUtc;
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(Date modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((createdUtc == null) ? 0 : createdUtc.hashCode());
		result = prime * result + id;
		result = prime * result + ((modifiedUtc == null) ? 0 : modifiedUtc.hashCode());
		result = prime * result + itemId;
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
		Note other = (Note) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
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
		if (itemId != other.itemId)
			return false;
		return true;
	}

}
