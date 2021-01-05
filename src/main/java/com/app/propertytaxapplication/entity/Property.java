package com.app.propertytaxapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "property")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Property implements Comparable<Property> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;

	private String description;

	public Property(int propertyId, String description) {
		super();
		this.propertyId = propertyId;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + propertyId;
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
		Property other = (Property) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (propertyId != other.propertyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", description=" + description + "]";
	}

	@Override
	public int compareTo(Property property) {
		return this.propertyId - property.getPropertyId();
	}

}
