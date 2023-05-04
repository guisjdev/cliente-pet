package br.com.petz.clientepet.clente.application.service;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.clente.application.api.ClienteRequest;
import br.com.petz.clientepet.clente.application.api.ClienteResponse;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationSevice - criaCliente");
		log.info("[finaliza] ClienteApplicationSevice - criaCliente");
		return null;
	}

}
