/**
 * 
 */
package dev.hotel.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

/**
 * @author vokankocak
 *
 */

@RestController()
@RequestMapping("clients")
public class ClientController {

/*	@RequestMapping(
			method = RequestMethod.GET
			)
	public String getClient(@RequestParam Integer start,
				@RequestParam Integer size){
		
		return  "requestParam = "+ start + size;
	
}*/
	
	private ClientRepository clientRepository;

/** Constructeur
 * @param clientRepository
 */
public ClientController(ClientRepository clientRepositroy) { 
	super();
	this.clientRepository = clientRepositroy;
}



@GetMapping // 
public List<Client> list(@RequestParam Integer start,
			@RequestParam Integer size){
	
	return  clientRepository.findAll();
	

}
@GetMapping("client/{id}")
public ResponseEntity<Client> getUUID(@PathVariable UUID id) {
	Client client = clientRepository.getByUUID(id);
	
	if(client == null) {
		return ResponseEntity.status(404)
				.body(null);
	}else {
		return ResponseEntity.status(200)
				.body(client);
	}
}
}