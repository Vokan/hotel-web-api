/**
 * 
 */
package dev.hotel.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
	
	
	@Test
	void list() throws Exception {

		 List<Client> list =new ArrayList<>();
		 Client client1 =new Client("Ross","Odd");
		 client1.setUuid(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192"));
		 list.add(client1);
		 
		 Page<Client> page = new PageImpl<>(list);
		 
		 Mockito.when(clientRepo.findAll(PageRequest.of(0, 1))).thenReturn(page);
		 
		 mockMvc.perform(
				 MockMvcRequestBuilders.get("/clients?start=0&size=1")).
		 andExpect(MockMvcResultMatchers.status().isOk()).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].uuid").value("dcf129f1-a2f9-47dc-8265-1d844244b192")).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Odd")).
		 andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Ross"));
	}
	
	@Test
	void findbyUUID() throws Exception{
		Client c1 = new Client("Odd", "Ross");
		c1.setUuid(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192"));
		
		Mockito.when(clientRepo.getByUUID(UUID.fromString("dcf129f1-a2f9-47dc-8265-1d844244b192"))).thenReturn(c1);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/client/dcf129f1-a2f9-47dc-8265-1d844244b192"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("nom").value("Odd"))
			.andExpect(MockMvcResultMatchers.jsonPath("prenoms").value("Ross"));
	}
}
