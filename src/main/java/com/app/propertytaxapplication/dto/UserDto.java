package com.app.propertytaxapplication.dto;

import com.app.propertytaxapplication.utils.STATUS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private String userName;

	private String email;

	private String address;

	private float totalTax;

	private int assessmentYear;

	private int constructedYear;

	private STATUS status;

	private int builtYear;

	private int zoneId;

	private int propertyId;

	public UserDto(String userName, String email, String address, float totalTax, int assessmentYear,
			int constructedYear, STATUS status, int builtYear, int zoneId, int propertyId) {
		super();
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.totalTax = totalTax;
		this.assessmentYear = assessmentYear;
		this.constructedYear = constructedYear;
		this.status = status;
		this.builtYear = builtYear;
		this.zoneId = zoneId;
		this.propertyId = propertyId;
	}

}
