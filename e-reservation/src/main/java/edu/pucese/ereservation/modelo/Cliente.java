package edu.pucese.ereservation.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity //represnta una tabla
@Table(name = "cliente") //nombre de la tabla
@NamedQuery(name="Cliente.findByIdentificacion",
query="Select c from Cliente c where c.identificacionCli = ?1")
public class Cliente {
	
//crear campo de la tabla
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonCli;
	private String emailCli;
	
	
	
	public Cliente() {
		
	}
	//relacion con la otra tabla en este caso reserva
	@OneToMany(mappedBy="cliente")
	private Set<Reserva> reservas;
	

	public String getIdCli() {
		return idCli;
	}

	public void setIdCli(String idCli) {
		this.idCli = idCli;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public String getApellidoCli() {
		return apellidoCli;
	}

	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}

	public String getIdentificacionCli() {
		return identificacionCli;
	}

	public void setIdentificacionCli(String identificacionCli) {
		this.identificacionCli = identificacionCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getTelefonCli() {
		return telefonCli;
	}

	public void setTelefonCli(String telefonCli) {
		this.telefonCli = telefonCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}
	
	
	
	

}
