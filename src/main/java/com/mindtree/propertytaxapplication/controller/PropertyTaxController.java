package com.mindtree.propertytaxapplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mindtree.propertytaxapplication.dto.UserDto;
import com.mindtree.propertytaxapplication.entity.Property;
import com.mindtree.propertytaxapplication.entity.Zone;
import com.mindtree.propertytaxapplication.entity.ZoneDetails;
import com.mindtree.propertytaxapplication.exception.PropertyTaxApplicationException;
import com.mindtree.propertytaxapplication.service.PropertyTaxService;
import com.mindtree.propertytaxapplication.utils.STATUS;

/**
 * @author M1057716
 *
 */
@Controller
public class PropertyTaxController {

	Map<String, HashMap<String, String>> testMap = new HashMap<String, HashMap<String, String>>();

	public void testMap() {
		HashMap<String, String> apple = new HashMap<>();
		apple.put("Tenanted", "Yes");
		apple.put("Owner", "No");
		testMap.put("1", testMap.getOrDefault("1", apple));
		testMap.put("2", testMap.getOrDefault("2", apple));
		testMap.put("3", testMap.getOrDefault("3", apple));
	}

	@Autowired
	private PropertyTaxService propService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String indexPage() {
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	private String indexHomePage() {
		return "error";
	}

	@RequestMapping(value = "/assessmentform", method = RequestMethod.GET)
	private String selfAssessmentForm(Model model) throws PropertyTaxApplicationException {
		UserDto userDto = new UserDto();
		model.addAttribute("userDto", userDto);
		List<Zone> zones = propService.fetchZones();
		model.addAttribute("zones", zones);
		List<ZoneDetails> zoneDetails = propService.fetchZoneDetails();
		model.addAttribute("zoneDetails", new Gson().toJson(zoneDetails));
		List<Property> properties = propService.fetchProperties();
		model.addAttribute("properties", properties);
		System.out.println(new Gson().toJson(properties));
		model.addAttribute("uav", new Gson().toJson(properties));
		return "form";
	}

	@RequestMapping(value = "/zonalreport", method = RequestMethod.GET)
	private String zonalWiseReport(Model model) throws PropertyTaxApplicationException {
		HashMap<String, String> apple = new HashMap<>();
		apple.put("Tenanted", "Yes");
		apple.put("Owner", "No");
		testMap.put("1", testMap.getOrDefault("1", apple));
		testMap.put("2", testMap.getOrDefault("2", apple));
		testMap.put("3", testMap.getOrDefault("3", apple));
		Map<String, Map<STATUS, Float>> report = propService.getUserDetails();
		System.out.println(report);
		model.addAttribute("report", report);
		return "report";
	}

	@RequestMapping(value = "/saveform", method = RequestMethod.POST)
	private String newForm(@ModelAttribute(value = "user") UserDto userDto) throws PropertyTaxApplicationException {
		propService.addNewUser(userDto);
		return "redirect:/";
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	private String calculate(@ModelAttribute(value = "user") UserDto userDto) throws PropertyTaxApplicationException {
		propService.addNewUser(userDto);
		return "successful";
	}
}
