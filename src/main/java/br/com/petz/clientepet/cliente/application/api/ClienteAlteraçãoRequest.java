package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteraçãoRequest {

	@NotBlank
	private String nomeCompleto;
	@NotBlank
	

	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	
	@NotNull
	private Boolean aceitaTermos;
}