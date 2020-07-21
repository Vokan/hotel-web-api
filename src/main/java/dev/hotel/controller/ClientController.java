/**
 * 
 */
package dev.hotel.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
public ResponseEntity<?> list(
		@RequestParam Integer start,
		@RequestParam Integer size){
	
	if (start==null||size==null||start<0||size<0) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
	}
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientRepository.findAll(PageRequest.of(start, size)).toList());
	

}

}