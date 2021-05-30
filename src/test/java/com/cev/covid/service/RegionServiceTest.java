package com.cev.covid.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RegionServiceTest {
	
	@Autowired
	private RegionService regionService;

    @Test
    void should_return_list_of_all_regions() {
        final var regions = regionService.getRegions();
        Assert.assertEquals(20, regions.size());
    }

    @Test
    void should_return_andalucia_region_by_name() {
        final var region = regionService.findByName("Andalusia");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_aragon_region_by_name() {
        final var region = regionService.findByName("Aragon");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_asturias_region_by_name() {
        final var region = regionService.findByName("Asturias");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_baleares_region_by_name() {
        final var region = regionService.findByName("Baleares");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_c_valenciana_region_by_name() {
        final var region = regionService.findByName("C. Valenciana");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_canarias_region_by_name() {
        final var region = regionService.findByName("Canarias");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_cantabria_region_by_name() {
        final var region = regionService.findByName("Cantabria");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_castilla_la_macnha_region_by_name() {
        final var region = regionService.findByName("Castilla - La Mancha");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_castilla_leon_region_by_name() {
        final var region = regionService.findByName("Castilla y Leon");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_catalonia_region_by_name() {
        final var region = regionService.findByName("Catalonia");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_ceuta_region_by_name() {
        final var region = regionService.findByName("Ceuta");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_extremadura_region_by_name() {
        final var region = regionService.findByName("Extremadura");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_galicia_region_by_name() {
        final var region = regionService.findByName("Galicia");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_la_rioja_region_by_name() {
        final var region = regionService.findByName("La Rioja");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_madrid_region_by_name() {
        final var region = regionService.findByName("Madrid");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_melilla_region_by_name() {
        final var region = regionService.findByName("Melilla");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_murcia_region_by_name() {
        final var region = regionService.findByName("Murcia");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_navarra_region_by_name() {
        final var region = regionService.findByName("Navarra");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_pais_vasco_region_by_name() {
        final var region = regionService.findByName("Pais Vasco");
        Assert.assertTrue(region.isPresent());
    }
    
    @Test
    void should_return_spain_region_by_name() {
        final var region = regionService.findByName("Spain");
        Assert.assertTrue(region.isPresent());
    }
}
