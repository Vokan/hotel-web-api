package dev.hotel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.hotel.entite.Client;

public interface ClientRepository extends JpaRepository<Client,UUID > {
	
	@Query("select c from Client c where c.uuid = ?1")
	Client getByUUID(UUID id);
}
