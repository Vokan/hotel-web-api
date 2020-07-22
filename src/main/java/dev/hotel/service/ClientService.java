/**
 * 
 */
package dev.hotel.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientRepository;

/**
 * @author vokankocak
 *
 */
@Service
public class ClientService {
	
		private ClientRepository clientRepo;

		/** Constructeur
		 * @param clientRepo
		 */
		public ClientService(ClientRepository clientRepo) {
			super();
			this.clientRepo = clientRepo;
		}
		
		@Transactional
		public Client creerClients (String nom, String prenom) {
			
			Client client = new Client(nom,prenom);
			
			Client clientSave = this.clientRepo.save(client);
			
			return clientSave;
		}
		
}
