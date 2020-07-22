/**
 * 
 */
package dev.hotel.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

/**
 * classe ClientDto  qui permet de crée un client
 * 
 * @author vokankocak
 *
 */
public class ClientDto {				// Classe qui permet de crée un client

	
	@NotNull
	@Size(min = 2)
	@NotBlank				//notBlank uniquement pour les chaines de carctères
	@JsonProperty("nom")
	private String nomClient;
	
	@JsonProperty("prenoms")
	@NotNull
	@NotBlank
	@Size(min=2)
	private String prenomClient;

	//Getters and Setters
	
	/** Getter
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/** Setter
	 * @param nomClient the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/** Getter
	 * @return the prenomClient
	 */
	public String getPrenomClient() {
		return prenomClient;
	}

	/** Setter
	 * @param prenomClient the prenomClient to set
	 */
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	
	
}
