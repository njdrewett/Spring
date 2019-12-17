package com.drewett.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drewett.model.Shipwreck;
import com.drewett.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<Shipwreck> list() {
		return shipwreckRepository.findAll();
	}
	
	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public Shipwreck create(@RequestBody final Shipwreck shipwreck) {
		return shipwreckRepository.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value = "shipwrecks/{id}",  method= RequestMethod.GET)
	public Shipwreck get(@PathVariable final Long id) {
		return shipwreckRepository.findOne(id);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public Shipwreck update(@PathVariable final Long id, @RequestBody final Shipwreck shipwreck) {
		Shipwreck existing = shipwreckRepository.findOne(id);
		BeanUtils.copyProperties(shipwreck, existing);
		return shipwreckRepository.saveAndFlush(existing);
	}
	
	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable final Long id) {
		Shipwreck existing = shipwreckRepository.findOne(id);
		shipwreckRepository.delete(id);
		return existing;
	}
	
}
