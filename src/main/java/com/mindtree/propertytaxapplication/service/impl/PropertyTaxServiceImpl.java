package com.mindtree.propertytaxapplication.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.propertytaxapplication.dao.PropertyTaxDao;
import com.mindtree.propertytaxapplication.dto.UserDto;
import com.mindtree.propertytaxapplication.entity.Property;
import com.mindtree.propertytaxapplication.entity.User;
import com.mindtree.propertytaxapplication.entity.Zone;
import com.mindtree.propertytaxapplication.entity.ZoneDetails;
import com.mindtree.propertytaxapplication.exception.service.PropertyTaxServiceException;
import com.mindtree.propertytaxapplication.service.PropertyTaxService;
import com.mindtree.propertytaxapplication.utils.STATUS;

/**
 * @author M1057716
 *
 */
@Service
@Transactional
public class PropertyTaxServiceImpl implements PropertyTaxService {

	private float amount = 0;

	@Autowired
	private PropertyTaxDao propertyTaxDao;

	@Override
	@Transactional
	public List<Zone> fetchZones() throws PropertyTaxServiceException {
		return propertyTaxDao.getZones();
	}

	@Override
	@Transactional
	public List<Property> fetchProperties() throws PropertyTaxServiceException {
		return propertyTaxDao.getProperties();
	}

	@Override
	@Transactional
	public void addNewUser(UserDto userDto) throws PropertyTaxServiceException {
		Zone zone = propertyTaxDao.getZone(userDto.getZoneId());
		Property property = propertyTaxDao.getproperty(userDto.getPropertyId());
		User user = new User(userDto.getUserName(), userDto.getEmail(), userDto.getAddress(), userDto.getTotalTax(),
				userDto.getAssessmentYear(), userDto.getConstructedYear(), userDto.getBuiltYear(), zone, property,
				userDto.getStatus());

		propertyTaxDao.addUser(user);
	}

	@Override
	@Transactional
	public List<ZoneDetails> fetchZoneDetails() throws PropertyTaxServiceException {
		return propertyTaxDao.getZoneDetails();
	}

	@Override
	@Transactional
	public Map<String, Map<STATUS, Float>> getUserDetails() throws PropertyTaxServiceException {
		List<User> users = propertyTaxDao.getUsers();
		List<Zone> zones = propertyTaxDao.getZones();
		List<STATUS> statuses = Arrays.asList(STATUS.values());

		Map<String, Map<STATUS, Float>> report = new HashMap<String, Map<STATUS, Float>>();

		zones.forEach(zone -> {
			Map<STATUS, Float> amountMap = new HashMap<STATUS, Float>();
			statuses.forEach(status -> {
				for (User user : users) {
					if (user.getZone().getZoneName().equals(zone.getZoneName())
							&& user.getStatus().ordinal() == status.ordinal()) {
						amount += user.getTotalTax();
					}
				}
				amountMap.put(status, amount);
				amount = 0;
			});
			report.put(zone.getZoneName(), amountMap);
		});
		return report;
	}
}
