package com.mindtree.propertytaxapplication.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mindtree.propertytaxapplication.utils.STATUS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "zoneDetails")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ZoneDetails implements Comparable<ZoneDetails> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private float rate;

	private STATUS status;

	@OneToOne(cascade = CascadeType.ALL)
	private Zone zone;

	@OneToOne(cascade = CascadeType.ALL)
	private Property property;

	public ZoneDetails(int id, float rate, STATUS status, Zone zone, Property property) {
		super();
		this.id = id;
		this.rate = rate;
		this.status = status;
		this.zone = zone;
		this.property = property;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		result = prime * result + Float.floatToIntBits(rate);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ZoneDetails other = (ZoneDetails) obj;
		if (id != other.id)
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		if (Float.floatToIntBits(rate) != Float.floatToIntBits(other.rate))
			return false;
		if (status != other.status)
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
		return "ZoneDetails [id=" + id + ", rate=" + rate + ", status=" + status + ", zone=" + zone + ", property="
				+ property + "]";
	}

	@Override
	public int compareTo(ZoneDetails zoneDetails) {
		return this.id - zoneDetails.getId();
	}
}
