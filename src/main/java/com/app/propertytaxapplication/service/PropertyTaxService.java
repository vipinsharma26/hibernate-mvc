package com.app.propertytaxapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.propertytaxapplication.dto.UserDto;
import com.app.propertytaxapplication.entity.Property;
import com.app.propertytaxapplication.entity.Zone;
import com.app.propertytaxapplication.entity.ZoneDetails;
import com.app.propertytaxapplication.exception.service.PropertyTaxServiceException;
import com.app.propertytaxapplication.utils.STATUS;

@Service
public interface PropertyTaxService {
	
	public List<Zone> fetchZones() throws PropertyTaxServiceException;

	public List<Property> fetchProperties() throws PropertyTaxServiceException;

	public void addNewUser(UserDto userDto) throws PropertyTaxServiceException;

	public List<ZoneDetails> fetchZoneDetails() throws PropertyTaxServiceException;

	public Map<String, Map<STATUS, Float>> getUserDetails() throws PropertyTaxServiceException;
}
