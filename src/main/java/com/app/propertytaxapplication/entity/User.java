package com.app.propertytaxapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.propertytaxapplication.utils.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class User implements Comparable<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;

	private String email;

	private String address;

	private float totalTax;

	private int assessmentYear;

	private int constructedYear;

	private int builtYear;

	@OneToOne(cascade = CascadeType.ALL)
	private Zone zone;

	@OneToOne(cascade = CascadeType.ALL)
	private Property property;

	private STATUS status;

	public User(String userName, String email, String address, float totalTax, int assessmentYear, int constructedYear,
			int builtYear, Zone zone, Property property, STATUS status) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.totalTax = totalTax;
		this.assessmentYear = assessmentYear;
		this.constructedYear = constructedYear;
		this.builtYear = builtYear;
		this.zone = zone;
		this.property = property;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + assessmentYear;
		result = prime * result + builtYear;
		result = prime * result + constructedYear;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Float.floatToIntBits(totalTax);
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((zone == null) ? 0 : zone.hashCode());
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
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (assessmentYear != other.assessmentYear)
			return false;
		if (builtYear != other.builtYear)
			return false;
		if (constructedYear != other.constructedYear)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (status != other.status)
			return false;
		if (Float.floatToIntBits(totalTax) != Float.floatToIntBits(other.totalTax))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (zone == null) {
			if (other.zone != null)
				return false;
		} else if (!zone.equals(other.zone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", address=" + address
				+ ", totalTax=" + totalTax + ", assessmentYear=" + assessmentYear + ", constructedYear="
				+ constructedYear + ", builtYear=" + builtYear + ", zone=" + zone + ", property=" + property
				+ ", status=" + status + "]";
	}

	@Override
	public int compareTo(User user) {
		return this.userId - user.getUserId();
	}

}
