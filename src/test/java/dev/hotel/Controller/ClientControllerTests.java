/**
 * 
 */
package dev.hotel.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.hotel.controller.ClientController;
import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

/**
 * @author vokankocak
 *
 */
@WebMvcTest(ClientController.class)
public class ClientControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
		
	@MockBean
	private ClientRepository clientRepo;
	
	protected List<Client> list =new ArrayList<>();
	
	@BeforeEach
	void setUp () {
		
		 Client client =new Client("Odd","Ross");
		 client.setUuid(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192"));
		 list.add(client);
	}
	
	@Test
	void list() throws Exception {

		 Page<Client> page = new PageImpl<>(list);
		 
		 Mockito.when(clientRepo.findAll(PageRequest.of(0,1))).thenReturn(page);
		 
		 mockMvc.perform(
				 MockMvcRequestBuilders.get("/clients?start=0&size=1")).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").value("dcf129f1-a2f9-47dc-8265-1d844244b192")).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Odd")).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Ross"));
	}
	
	@Test
	void findByUuidTest() throws Exception{
		

		 Mockito.when(clientRepo.findById(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192"))).thenReturn(Optional.of(this.list.get(0)));
		 
		 mockMvc.perform(
				 MockMvcRequestBuilders.get("/clients/dcf129f1-a2f9-47dc-8265-1d844244b192")).
		 andExpect(MockMvcResultMatchers.status().isOk()).
 		 andExpect(MockMvcResultMatchers.jsonPath("$.uuid").value("dcf129f1-a2f9-47dc-8265-1d844244b192")).
		 andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Odd")).
		 andExpect(MockMvcResultMatchers.jsonPath("$.prenoms").value("Ross"));
	}
	
}
