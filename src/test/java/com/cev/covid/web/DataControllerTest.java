package com.cev.covid.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cev.covid.service.DataService;

@WebMvcTest(DataController.class)
class DataControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DataService dataService;
    
    @Test
    void should_return_status_200_when_requesting_all_data() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/data"))
        .andExpect(status().isOk());
    }

    @Test
    void should_return_status_200_when_serching_for_andalucia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "andalusia"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_aragon_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "aragon"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_asturias_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "asturias"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_baleares_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "baleares"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_c_valenciana_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "c. valenciana"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_cantabria_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "cantabria"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_catilla_la_mancha_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "Castilla - La Mancha"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_castilla_la_mancha_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "Castilla y Leon"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_catalonia_region() throws Exception {
    	mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "catalonia"))
    	.andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_ceuta_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "ceuta"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_extremadura_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "extremadura"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_galicia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "galicia"))
        .andExpect(status().isOk());
    }
        
    @Test
    void should_return_status_200_when_serching_for_la_rioja_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "la rioja"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_madrid_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "madrid"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_melilla_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "melilla"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_murcia_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "murcia"))
        .andExpect(status().isOk());
    }

    @Test
    void should_return_status_200_when_serching_for_navarra_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "navarra"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_pais_vasco_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "pais vasco"))
        .andExpect(status().isOk());
    }
    
    @Test
    void should_return_status_200_when_serching_for_spain_vasco_region() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/dataRegion/{name}", "spain"))
        .andExpect(status().isOk());
    }
}
