package com.ge;

public class ResultObject {

	private String fieldName;
	private Object oldObjectValue;
	private Object newObjectValue;

	
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getOldObjectValue() {
		return oldObjectValue;
	}
	public void setOldObjectValue(Object oldObjectValue) {
		this.oldObjectValue = oldObjectValue;
	}
	public Object getNewObjectValue() {
		return newObjectValue;
	}
	public void setNewObjectValue(Object newObjectValue) {
		this.newObjectValue = newObjectValue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((newObjectValue == null) ? 0 : newObjectValue.hashCode());
		result = prime * result + ((oldObjectValue == null) ? 0 : oldObjectValue.hashCode());
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
		ResultObject other = (ResultObject) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (newObjectValue == null) {
			if (other.newObjectValue != null)
				return false;
		} else if (!newObjectValue.equals(other.newObjectValue))
			return false;
		if (oldObjectValue == null) {
			if (other.oldObjectValue != null)
				return false;
		} else if (!oldObjectValue.equals(other.oldObjectValue))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ResultObject [fieldName=" + fieldName + ", oldObjectValue=" + oldObjectValue + ", newObjectValue="
				+ newObjectValue + "]";
	}
	
	
}
