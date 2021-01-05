package com.mindtree.propertytaxapplication.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mindtree.propertytaxapplication.dto.UserDto;
import com.mindtree.propertytaxapplication.entity.Property;
import com.mindtree.propertytaxapplication.entity.Zone;
import com.mindtree.propertytaxapplication.entity.ZoneDetails;
import com.mindtree.propertytaxapplication.exception.service.PropertyTaxServiceException;
import com.mindtree.propertytaxapplication.utils.STATUS;

@Service
public interface PropertyTaxService {
	
	public List<Zone> fetchZones() throws PropertyTaxServiceException;

	public List<Property> fetchProperties() throws PropertyTaxServiceException;

	public void addNewUser(UserDto userDto) throws PropertyTaxServiceException;

	public List<ZoneDetails> fetchZoneDetails() throws PropertyTaxServiceException;

	public Map<String, Map<STATUS, Float>> getUserDetails() throws PropertyTaxServiceException;
}
