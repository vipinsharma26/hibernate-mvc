package com.app.propertytaxapplication.dao;

import java.util.List;

import com.app.propertytaxapplication.entity.Property;
import com.app.propertytaxapplication.entity.User;
import com.app.propertytaxapplication.entity.Zone;
import com.app.propertytaxapplication.entity.ZoneDetails;
import com.app.propertytaxapplication.exception.service.PropertyTaxServiceException;

public interface PropertyTaxDao {

	public List<Zone> getZones() throws PropertyTaxServiceException;

	public List<Property> getProperties() throws PropertyTaxServiceException;
	
	public Zone getZone(int zoneId) throws PropertyTaxServiceException;

	public Property getproperty(int propertyId) throws PropertyTaxServiceException;

	public void addUser(User user);

	public List<ZoneDetails> getZoneDetails() throws PropertyTaxServiceException;

	public List<User> getUsers() throws PropertyTaxServiceException;
}
