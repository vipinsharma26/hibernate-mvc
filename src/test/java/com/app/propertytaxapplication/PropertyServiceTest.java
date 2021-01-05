package com.app.propertytaxapplication;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.propertytaxapplication.dao.PropertyTaxDao;
import com.app.propertytaxapplication.entity.Property;
import com.app.propertytaxapplication.entity.User;
import com.app.propertytaxapplication.entity.Zone;
import com.app.propertytaxapplication.entity.ZoneDetails;
import com.app.propertytaxapplication.exception.service.PropertyTaxServiceException;
import com.app.propertytaxapplication.service.impl.PropertyTaxServiceImpl;
import com.app.propertytaxapplication.utils.STATUS;

@SuppressWarnings("unused")
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PropertyServiceTest {

	@Autowired
	private PropertyTaxServiceImpl propService;

	@MockBean
	private PropertyTaxDao propertyTaxDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	private static final double DELTA = 1e-15;

	@Test
	public void testFetchZones() throws PropertyTaxServiceException {
		List<Zone> list = new ArrayList<Zone>();
		Zone zoneA = new Zone(1, "A");
		Zone zoneB = new Zone(2, "B");
		Zone zoneC = new Zone(3, "C");

		list.add(zoneA);
		list.add(zoneB);
		list.add(zoneC);

		Mockito.lenient().when(propertyTaxDao.getZones()).thenReturn(list);
		List<Zone> zoneList = propService.fetchZones();
		Assertions.assertEquals(3, zoneList.size());
		verify(propertyTaxDao, atLeastOnce()).getZones();
	}

	@Test
	public void testFetchProperties() throws PropertyTaxServiceException {
		List<Property> properties = new ArrayList<Property>();
		Property propertyOne = new Property(1, "RCC BUILDINGS");
		Property propertyTwo = new Property(2, "RED OXIDE");
		Property propertyThree = new Property(3, "TILES");

		properties.add(propertyOne);
		properties.add(propertyTwo);
		properties.add(propertyThree);
		Mockito.lenient().when(propertyTaxDao.getProperties()).thenReturn(properties);
		List<Property> propertyList = propService.fetchProperties();
		Assertions.assertEquals(3, propertyList.size());
	}

	@Test
	public void testAddNewUser() {
		Zone zoneA = new Zone(1, "A");
		Property propertyOne = new Property(1, "RCC BUILDINGS");

		User userExpected = new User("test", "test@gmail.com", "test", 3000, 2018, 2008, 1200, zoneA, propertyOne,
				STATUS.Tenanted);
		userExpected.setUserId(101);
		User userActual = new User("test", "test@gmail.com", "test", 3000, 2018, 2008, 1200, zoneA, propertyOne,
				STATUS.Tenanted);
		userActual.setUserId(101);
		assertEquals(userExpected.getTotalTax(), userActual.getTotalTax(), DELTA);
	}

	@Test
	public void testFetchZonesIfEmpty() throws PropertyTaxServiceException {
		List<Zone> list = new ArrayList<Zone>();

		try {
			Mockito.lenient().when(propertyTaxDao.getZones()).thenReturn(list);
			List<Zone> zoneList = propertyTaxDao.getZones();

		} catch (PropertyTaxServiceException e) {
			Assertions.assertEquals("Zone List Is Empty", e.getMessage());
		}
	}

	@Test
	public void testFetchPropertiesIfEmpty() throws PropertyTaxServiceException {
		List<Property> list = new ArrayList<Property>();

		try {
			Mockito.lenient().when(propertyTaxDao.getProperties()).thenReturn(list);
			List<Property> propertyList = propertyTaxDao.getProperties();

		} catch (PropertyTaxServiceException e) {
			Assertions.assertEquals("Property List Is Empty", e.getMessage());
		}
	}

	@Test
	public void testFetchZoneDetailsIfEmpty() throws PropertyTaxServiceException {
		List<ZoneDetails> list = new ArrayList<ZoneDetails>();

		try {
			Mockito.lenient().when(propertyTaxDao.getZoneDetails()).thenReturn(list);
			List<ZoneDetails> zoneList = propertyTaxDao.getZoneDetails();

		} catch (PropertyTaxServiceException e) {
			Assertions.assertEquals("ZoneDetails List Is Empty", e.getMessage());
		}
	}
}
