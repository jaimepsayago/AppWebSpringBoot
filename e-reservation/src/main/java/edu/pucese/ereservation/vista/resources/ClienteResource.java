package edu.pucese.ereservation.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pucese.ereservation.business.services.ClienteService;
import edu.pucese.ereservation.modelo.Cliente;
import edu.pucese.ereservation.vista.resources.vo.ClienteVo;

@RestController
@RequestMapping("api/cliente")
public class ClienteResource {
	
	//implementar
	private final ClienteService clienteService; 
	 
	 public ClienteResource(ClienteService clienteService)
	 {   
		 this.clienteService = clienteService;  
	 } 
	
	 //crear
	 @PostMapping  
	 public ResponseEntity<Cliente> 
	 createCliente(@RequestBody ClienteVo clienteVo)
	 {      
		 Cliente cliente = new Cliente();   
		 cliente.setNombreCli(clienteVo.getNombreCli());   
		 cliente.setApellidoCli(clienteVo.getApellidoCli());  
		 cliente.setDireccionCli(clienteVo.getDireccionCli());   
		 cliente.setTelefonCli(clienteVo.getTelefonoCli());   
		 cliente.setEmailCli(clienteVo.getEmailCli());   
		return new ResponseEntity<>(this.clienteService.create(cliente),
				HttpStatus.CREATED);  
	}
	 
	 @PutMapping("/{identificacion}")  
	 public ResponseEntity<Cliente> updateCliente(@PathVariable("identificacion") 
	 String identificacion,    ClienteVo clienteVo) { 
		 
		  Cliente cliente = 
				  this.clienteService.findByIdentificacion(identificacion);   
		  if (cliente == null) {    
			  return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);   }
		  else {    
			  cliente.setNombreCli(clienteVo.getNombreCli());    
			  cliente.setApellidoCli(clienteVo.getApellidoCli());    
			  cliente.setDireccionCli(clienteVo.getDireccionCli());    
			  cliente.setTelefonCli(clienteVo.getTelefonoCli());     
			  cliente.setEmailCli(clienteVo.getEmailCli());   
			  }   
		  return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);  
		  } 
	 
	 @DeleteMapping("/{identificacion}")  
	 public void removeCliente(@PathVariable("identificacion") String identificacion) 
	 {   Cliente cliente = this.clienteService.findByIdentificacion(identificacion);  
	 if (cliente != null) {    
		 this.clienteService.delete(cliente);   
	 }  
	 } 
	 
	 @GetMapping  
	 public ResponseEntity<List<Cliente>> findAll() 
	 {   
		 return ResponseEntity.ok(this.clienteService.findAll()); 
	 } 
	 
		 
		}  


