package br.com.petz.clientepet.clente.application.service;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.clente.application.api.ClienteRequest;
import br.com.petz.clientepet.clente.application.api.ClienteResponse;
import br.com.petz.clientepet.clente.application.repository.ClienteRepository;
import br.com.petz.clientepet.clente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationSevice - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationSevice - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

}
