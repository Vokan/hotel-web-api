/**
 * 
 */
package dev.hotel.controller;


import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.Dto.ClientDto;
import dev.hotel.Dto.ReservationDto;
import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;
import dev.hotel.service.ClientService;

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
	
	private ClientRepository clientRepository; // permet de communiquer avec la Base
	
	private ClientService clientService;
		
	
	
/** Constructeur
 * @param clientRepository
 */
	
public ClientController(ClientRepository clientRepositroy, ClientService clientService) { 
	super();
	this.clientRepository = clientRepositroy;
	this.clientService=clientService;
}



@GetMapping 
public ResponseEntity<?> list(
		@RequestParam Integer start,
		@RequestParam Integer size){
	
	if (start==null||size==null||start<0||size<0) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
	}
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientRepository.findAll(PageRequest.of(start, size)).toList());
	

}

@GetMapping("/{uuid}")
public ResponseEntity<?> findByUuid(@PathVariable UUID uuid){
	  Optional<Client> client= clientRepository.findById(uuid);
	
	  
	  if (!client.isPresent()) {
		
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("l'UUID ne corresponds a aucun client");	
		} 
	  
	  else {
		
		  return ResponseEntity.status(HttpStatus.OK).body(client.get());
}
}
	// crée un client

@PostMapping
public ResponseEntity<?> creerClient(@RequestBody @Valid ClientDto client, BindingResult result){
	
	if(result.hasErrors()) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ajouter un prenom et un nom");
	}
	else {
		Client clientCreer = clientService.creerClients(client.getNomClient(), client.getPrenomClient());
		
		return ResponseEntity.status(HttpStatus.OK).body(clientCreer);
	}
}

// crée une réservation
@PostMapping("/reservation")
public ResponseEntity<?>creerReservation(@RequestBody @Valid ReservationDto reservation, BindingResult result){
	
}
}