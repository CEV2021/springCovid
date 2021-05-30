package com.cev.covid.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataServiceTest {

	@Autowired
	private DataService dataService;

	@Test
	void should_return_list_with_data() {
		final var data = dataService.getData();
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_andalucia() {
		final var data = dataService.getDataRegion("Andalusia");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_aragon() {
		final var data = dataService.getDataRegion("Aragon");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_asturias() {
		final var data = dataService.getDataRegion("Asturias");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_baleares() {
		final var data = dataService.getDataRegion("Baleares");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_c_valenciana() {
		final var data = dataService.getDataRegion("C. Valenciana");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_canarias() {
		final var data = dataService.getDataRegion("Canarias");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_cantabria() {
		final var data = dataService.getDataRegion("Cantabria");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_castilla_mancha() {
		final var data = dataService.getDataRegion("Castilla - La Mancha");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_castilla_leon() {
		final var data = dataService.getDataRegion("Castilla y Leon");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_catalonia() {
		final var data = dataService.getDataRegion("Catalonia");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_ceuta() {
		final var data = dataService.getDataRegion("Ceuta");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_extremadura() {
		final var data = dataService.getDataRegion("Extremadura");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_galicia() {
		final var data = dataService.getDataRegion("Galicia");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_la_rioja() {
		final var data = dataService.getDataRegion("La Rioja");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_madrid() {
		final var data = dataService.getDataRegion("Madrid");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_melilla() {
		final var data = dataService.getDataRegion("Melilla");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_murcia() {
		final var data = dataService.getDataRegion("Murcia");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_navarra() {
		final var data = dataService.getDataRegion("Navarra");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_pais_vasco() {
		final var data = dataService.getDataRegion("Pais Vasco");
		Assert.assertFalse(data.isEmpty());
	}

	@Test
	void should_return_list_with_data_for_spain() {
		final var data = dataService.getDataRegion("Spain");
		Assert.assertFalse(data.isEmpty());
	}
}
