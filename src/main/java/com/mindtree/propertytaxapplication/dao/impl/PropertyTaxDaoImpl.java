package com.mindtree.propertytaxapplication.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.propertytaxapplication.dao.PropertyTaxDao;
import com.mindtree.propertytaxapplication.entity.Property;
import com.mindtree.propertytaxapplication.entity.User;
import com.mindtree.propertytaxapplication.entity.Zone;
import com.mindtree.propertytaxapplication.entity.ZoneDetails;
import com.mindtree.propertytaxapplication.exception.custom.NoPropertyException;
import com.mindtree.propertytaxapplication.exception.custom.NoUserException;
import com.mindtree.propertytaxapplication.exception.custom.NoZoneDetailsException;
import com.mindtree.propertytaxapplication.exception.custom.NoZoneException;
import com.mindtree.propertytaxapplication.exception.service.PropertyTaxServiceException;

/**
 * @author M1057716
 *
 */
@Repository
public class PropertyTaxDaoImpl implements PropertyTaxDao {

	@Autowired
	private HibernateTemplate hibernateTeamplate;

	@Override
	public List<Zone> getZones() throws PropertyTaxServiceException {
		List<Zone> zones = hibernateTeamplate.loadAll(Zone.class);
		if (zones.isEmpty()) {
			throw new NoZoneException("Zone List Is Empty");
		}
		return zones;
	}

	@Override
	public List<Property> getProperties() throws PropertyTaxServiceException {
		List<Property> properties = hibernateTeamplate.loadAll(Property.class);
		if (properties.isEmpty()) {
			throw new NoPropertyException("Property List Is Empty");
		}
		return properties;
	}

	@Override
	public Zone getZone(int zoneId) throws PropertyTaxServiceException {
		Zone zone = hibernateTeamplate.load(Zone.class, zoneId);
		if (zone == null) {
			throw new NoZoneException("No Zone with the id " + zoneId + " found");
		}
		return zone;
	}

	@Override
	public Property getproperty(int propertyId) throws PropertyTaxServiceException {
		Property property = hibernateTeamplate.load(Property.class, propertyId); // or with Sessionfactory
		if (property == null) {
			throw new NoPropertyException("No Zone with the id " + propertyId + " found");
		}
		return property;
	}

	@Override
	public void addUser(User user) {
		hibernateTeamplate.save(user);
	}

	@Override
	public List<ZoneDetails> getZoneDetails() throws PropertyTaxServiceException {
		List<ZoneDetails> zoneDetails = hibernateTeamplate.loadAll(ZoneDetails.class);
		if (zoneDetails.isEmpty()) {
			throw new NoZoneDetailsException("ZoneDetails List Is Empty");
		}
		return zoneDetails;
	}

	@Override
	public List<User> getUsers() throws PropertyTaxServiceException {
		List<User> users = hibernateTeamplate.loadAll(User.class);
		if (users.isEmpty()) {
			throw new NoUserException("Users List Is Empty");
		}
		return users;
	}

}
