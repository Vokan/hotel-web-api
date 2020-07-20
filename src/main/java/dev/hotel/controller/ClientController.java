/**
 * 
 */
package dev.hotel.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		return  "requestParam nb1= "+ start + size;
	
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
}