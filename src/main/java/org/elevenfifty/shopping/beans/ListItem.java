package org.elevenfifty.shopping.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.elevenfifty.shopping.Priority;

@Entity
@Table(name = "list_items")
public class ListItem {
	//Anthony: adding in variables per the TDD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int listId;
	private String contents;
	private boolean isChecked;
	//Anthony: created custom class to create a DateTimeOffset since it is a SQL only type of variable Edit: Went with simple Date type
	private Date createdUtc;
	private Date modifiedUtc;
	//Anthony: casting a series of enums as integers for a series of different outputs
	private Priority priority;

	//Anthony: use Java.util.Date for this to mesh with SQL timestamp
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
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

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((createdUtc == null) ? 0 : createdUtc.hashCode());
		result = prime * result + id;
		result = prime * result + (isChecked ? 1231 : 1237);
		result = prime * result + ((modifiedUtc == null) ? 0 : modifiedUtc.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + listId;
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
		ListItem other = (ListItem) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (createdUtc == null) {
			if (other.createdUtc != null)
				return false;
		} else if (!createdUtc.equals(other.createdUtc))
			return false;
		if (id != other.id)
			return false;
		if (isChecked != other.isChecked)
			return false;
		if (modifiedUtc == null) {
			if (other.modifiedUtc != null)
				return false;
		} else if (!modifiedUtc.equals(other.modifiedUtc))
			return false;
		if (priority != other.priority)
			return false;
		if (listId != other.listId)
			return false;
		return true;
	}
	
	

}