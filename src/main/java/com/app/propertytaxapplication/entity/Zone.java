package com.app.propertytaxapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "zone")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Zone implements Comparable<Zone> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zoneId;

	private String zoneName;

	public Zone(int zoneId, String zoneName) {
		super();
		this.zoneId = zoneId;
		this.zoneName = zoneName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + zoneId;
		result = prime * result + ((zoneName == null) ? 0 : zoneName.hashCode());
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
		Zone other = (Zone) obj;
		if (zoneId != other.zoneId)
			return false;
		if (zoneName == null) {
			if (other.zoneName != null)
				return false;
		} else if (!zoneName.equals(other.zoneName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zone [zoneId=" + zoneId + ", zoneName=" + zoneName + "]";
	}

	@Override
	public int compareTo(Zone zone) {
		return this.zoneId - zone.getZoneId();
	}

}
