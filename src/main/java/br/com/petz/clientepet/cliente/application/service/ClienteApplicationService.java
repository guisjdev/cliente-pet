package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteraçãoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
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

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicationSevice - buscaTodosClientes");
		List<Cliente> clientes = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicationSevice - buscaTodosClientes");
		return ClienteListResponse.convert(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationSevice - buscaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteApplicationSevice - buscaClienteAtravesId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationSevice - deletaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		clienteRepository.deletaCliente(cliente);
		log.info("[finaliza] ClienteApplicationSevice - deletaClienteAtravesId");
		
		
	}

	@Override
	public void patchAlteraCliente(UUID idCliente, ClienteAlteraçãoRequest clienteAlteraçãoRequest) {
		log.info("[inicia] ClienteApplicationSevice - patchAlteraCliente");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		cliente.altera(clienteAlteraçãoRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza] ClienteApplicationSevice - patchAlteraCliente");
		
		
	}

}
