package br.com.petz.clientepet.clente.application.service;

import br.com.petz.clientepet.clente.application.api.ClienteRequest;
import br.com.petz.clientepet.clente.application.api.ClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(ClienteRequest clienteRequest);

}