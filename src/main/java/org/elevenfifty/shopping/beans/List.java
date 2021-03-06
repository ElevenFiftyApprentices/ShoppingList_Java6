package org.elevenfifty.shopping.beans;

import java.util.Date;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "lists")
public class List {
	//adding in variables per the TDD
	
//	@OneToMany(mappedBy="list", cascade = CascadeType.ALL)
//		private List <ListItem> listItems;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name="id")
	private int id;

	
	private int listId;
	
	private int userId;

	private String name;
	

	private String color;
	

	public boolean isChecked;

	
	public boolean isChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}
	
//	public Lists<String> getListOfLists(){
//		return listOfLists;
//	}
//	
//	public void setListOfLists(Lists<String> listOfLists){
//		this.listOfLists = listOfLists;
//	}

	//use Java.util.Date for this to mesh with SQL timestamp
	private Date createdUtc;
	private Date modifiedUtc;

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
		List other = (List) obj;
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
//	
//	public ShoppingList<ListItem> getListItems() {
//		return listItems;
//	}
//
//	public void setListItems(ShoppingList<ListItem> listItems) {
//		this.listItems = listItems;
//	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}


}