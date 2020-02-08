package edu.pucese.ereservation.business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pucese.ereservation.business.repository.ClientRepository;
import edu.pucese.ereservation.modelo.Cliente;

@Service
public class ClienteService {
	private final ClientRepository clientRepository;
	
	public ClienteService(ClientRepository clientRepository) {
		this.clientRepository= clientRepository;
	}
	
	//crear
	public Cliente create(Cliente cliente) {
		return this.clientRepository.save(cliente);
	}
	//modificar
	public Cliente update (Cliente cliente) {
		return this.clientRepository.save(cliente);
	}
	//listar
	public List<Cliente> findAll(){
		return this.clientRepository.findAll();
	}
	//eliminar
	public void delete(Cliente cliente) {
		this.clientRepository.delete(cliente);
	}
	//buscar por identificador
	public Cliente findByIdentificacion(String identificacionCli) {
		return this.clientRepository.findByIdentificacionCli(identificacionCli);
	}

}
