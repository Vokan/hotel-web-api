package dev.hotel.Dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class ReservationDto {

	

	@NotNull
	@JsonProperty("dateDebut")
	private LocalDate dateDebut;
	
	@JsonProperty("dateFin")
	@NotNull
	private LocalDate dateFin;
	
	@JsonProperty("clientId")
	@NotNull
	private UUID uuidClient;
	
	@JsonProperty("chambresUuid")
	@NotNull
	private List<UUID> uuidChambre;
	
	
	
	
		/** Constructeur
	 * 
	 */
	public ReservationDto() {
		super();
	}

		//Getters and Setters

	/** Getter
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the uuidClient
	 */
	public UUID getUuidClient() {
		return uuidClient;
	}

	/** Setter
	 * @param uuidClient the uuidClient to set
	 */
	public void setUuidClient(UUID uuidClient) {
		this.uuidClient = uuidClient;
	}

	/** Getter
	 * @return the uuidChambre
	 */
	public List<UUID> getUuidChambre() {
		return uuidChambre;
	}

	/** Setter
	 * @param uuidChambre the uuidChambre to set
	 */
	public void setUuidChambre(List<UUID> uuidChambre) {
		this.uuidChambre = uuidChambre;
	}
	
	
	

	
	

}
