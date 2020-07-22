/**
 * 
 */
package dev.hotel.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.hotel.entite.Client;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ReservationRepository;

/**
 * @author vokankocak
 *
 */

@Service
public class ReservationService {
	
	private ReservationRepository reservationRepository;
	
	private ChambreRepository chambreRepository;
	
	protected ClientService clientService;

	
	/** Constructeur
	 * @param reservationRepository
	 * @param chambreRepository
	 * @param clientService
	 */
	public ReservationService(ReservationRepository reservationRepository, ChambreRepository chambreRepository,
			ClientService clientService) {
		super();
		this.reservationRepository = reservationRepository;
		this.chambreRepository = chambreRepository;
		this.clientService = clientService;
	}

	@Transactional
	public Reservation ajouter(LocalDate dateDebut, LocalDate dateFin, UUID clientId, List<UUID> chambresUuid) {
	
		// Récupération de l'uuid client
				Client client = clientService.afficher(clientId)
						.orElseThrow(() -> new ReservationException("uuid client non trouvé"));
	
				
		// Ajout de chaque chambre
		for (UUID uuid : chambresUuid) {
			Chambre chambre = chambreRepository.findById(uuid).orElseThrow(() -> new ReservationException("la chambre n'existe pas"));
			listChambre.add(chambre);
				}
	}
	
}
