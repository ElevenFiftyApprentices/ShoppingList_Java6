package org.elevenfifty.shopping.beans;

import org.elevenfifty.shopping.DateTimeOffset;

public class Note {
private int id;
private int shoppingListItemId;
private String body;
private DateTimeOffset createdUtc;
private DateTimeOffset modifiedUtc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getShoppingListItemId() {
	return shoppingListItemId;
}
public void setShoppingListItemId(int shoppingListItemId) {
	this.shoppingListItemId = shoppingListItemId;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
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
	result = prime * result + ((body == null) ? 0 : body.hashCode());
	result = prime * result + ((createdUtc == null) ? 0 : createdUtc.hashCode());
	result = prime * result + id;
	result = prime * result + ((modifiedUtc == null) ? 0 : modifiedUtc.hashCode());
	result = prime * result + shoppingListItemId;
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
	if (shoppingListItemId != other.shoppingListItemId)
		return false;
	return true;
}


}
