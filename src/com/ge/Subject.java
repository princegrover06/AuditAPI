package com.ge;

public class Subject {

	private Long id;
	private String maths;
	private String science;
	private String english;
	private String computer;
	private Long total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getComputer() {
		return computer;
	}
	public void setComputer(String computer) {
		this.computer = computer;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((computer == null) ? 0 : computer.hashCode());
		result = prime * result + ((english == null) ? 0 : english.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((maths == null) ? 0 : maths.hashCode());
		result = prime * result + ((science == null) ? 0 : science.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Subject other = (Subject) obj;
		if (computer == null) {
			if (other.computer != null)
				return false;
		} else if (!computer.equals(other.computer))
			return false;
		if (english == null) {
			if (other.english != null)
				return false;
		} else if (!english.equals(other.english))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maths == null) {
			if (other.maths != null)
				return false;
		} else if (!maths.equals(other.maths))
			return false;
		if (science == null) {
			if (other.science != null)
				return false;
		} else if (!science.equals(other.science))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", maths=" + maths + ", science=" + science + ", english=" + english
				+ ", computer=" + computer + ", total=" + total + "]";
	}
	
	
}
