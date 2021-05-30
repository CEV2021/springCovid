package com.cev.covid.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cev.covid.service.DataService;
import com.cev.covid.service.RegionService;

@WebMvcTest(RegionController.class)
class RegionControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegionService regionService;
    @MockBean
    private DataService dataService;
    
    @Test
    void should_return_status_200_when_requesting_all_regions() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions"))
        .andExpect(status().isOk());
    }

    @Test
    void should_return_status_200_when_searching_for_andalucia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "andalusia"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_aragon_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "aragon"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_asturias_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "asturias"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_baleares_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "baleares"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_c_valenciana_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "c. valenciana"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_cantabria_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "cantabria"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_catilla_la_mancha_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "Castilla - La Mancha"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_castilla_la_mancha_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "Castilla y Leon"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_catalonia_region() throws Exception {
    	mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "catalonia"))
    	.andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_ceuta_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "ceuta"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_extremadura_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "extremadura"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_galicia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "galicia"))
        .andExpect(status().isOk());
    }
        
    @Test
    void should_return_status_200_when_searching_for_la_rioja_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "la rioja"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_madrid_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "madrid"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_melilla_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "melilla"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_murcia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "murcia"))
        .andExpect(status().isOk());
    }

    @Test
    void should_return_status_200_when_searching_for_navarra_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "navarra"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_pais_vasco_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "pais vasco"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_searching_for_spain_vasco_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/regions/{name}", "spain"))
        .andExpect(status().isOk());
    }
}
