package org.elevenfifty.shopping.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.elevenfifty.shopping.DateTimeOffset;
import org.elevenfifty.shopping.Priority;

public class ShoppingListItem {
	//adding in variables per the TDD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int shoppingListId;
	private String contents;
	private boolean isChecked;
	//created custom class to create a DateTimeOffset since it is a SQL only type of variable
	private DateTimeOffset createdUtc;
	private DateTimeOffset modifiedUtc;
	//casting a series of enums as integers for a series of different outputs
	private Priority priority;

	//getters setters and hash coding and equals for variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
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
		result = prime * result + shoppingListId;
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
		ShoppingListItem other = (ShoppingListItem) obj;
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
		if (shoppingListId != other.shoppingListId)
			return false;
		return true;
	}

}
