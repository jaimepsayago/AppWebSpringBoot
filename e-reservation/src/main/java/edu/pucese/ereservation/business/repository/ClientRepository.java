package edu.pucese.ereservation.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pucese.ereservation.modelo.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, String> {

	//buscasr clientes por su apellido
	public List<Cliente> findByApellidoCli(String apellidoCli);
	
	//buscar cliente por identificacion
	public Cliente findByIdentificacionCli(String identificacionCli);
	

	
}
