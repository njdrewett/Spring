package com.drewett;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.drewett.controller.ShipwreckController;
import com.drewett.model.Shipwreck;
import com.drewett.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController shipwreckController;

	@Mock 
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {		
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1l);
		when(shipwreckRepository.findOne(1l)).thenReturn(shipwreck);
		
		Shipwreck wreck = shipwreckController.get(1l);
		
		verify(shipwreckRepository).findOne(1l);
		//assertEquals(1l, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1l));
	}
}
