package com.manuelcodigo.crudproyectosxideral.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;


@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public DesarrolladorServiceImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Desarrollador> mostrarTodos() {
//		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Desarrollador>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Desarrollador>>() {});

		// get the list of customers from response
		List<Desarrollador> desarrolladores = responseEntity.getBody();

		logger.info("in findAll(): desarrolladores" + desarrolladores);
		
		return desarrolladores;
	}

	@Override
	public Desarrollador mostrarPorId(int id) {

//		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);

		// make REST call
		Desarrollador desarrollador = 
				restTemplate.getForObject(crmRestUrl + "/" + id, 
						Desarrollador.class);

		logger.info("in findById(): desarrollador=" + desarrollador);
		
		return desarrollador;
	}

	@Override
	public void guardar(Desarrollador desarrollador) {
//		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		
		int desarrolladorId = desarrollador.getId();

		// make REST call
		if (desarrolladorId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, desarrollador, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, desarrollador);
		}

		logger.info("in Desarrollador save(): success");	
		
	}

	@Override
	public void eliminar(int id) {
		
//		logger.info("in deleteById(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + id);

		logger.info("in deleteById(): deleted desarrollador theId=" + id);
		
	}

	

	
	
}






