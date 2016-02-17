package com.nitesh.junit.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;

public class HeatEngineMockitoTest {

	@Mock
	private ICity city;
	private HeatEngine heatEngine;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		heatEngine = new HeatEngine();
	}

	@Test
	public void ShouldSetStatusAsLowWhenTemperaturLowerThan50() {
		when(city.getTemperature()).thenReturn(37);
		assertEquals(HeatEngine.LOW, heatEngine.getStatus(city));
	}
}
