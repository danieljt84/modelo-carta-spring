package com.br.model;

import java.time.LocalDate;

public class CartaSimplesSp extends ModeloCarta {
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmpresaContratante() {
		return empresaContratante;
	}
	public void setEmpresaContratante(String empresaContratante) {
		this.empresaContratante = empresaContratante;
	}
	public String getEnderecoLoja() {
		return enderecoLoja;
	}
	public void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}
	public String getNomePromotor() {
		return nomePromotor;
	}
	public void setNomePromotor(String nomePromotor) {
		this.nomePromotor = nomePromotor;
	}
	public String getcartPromotor() {
		return cartPromotor;
	}
	public void setcartPromotor(String cartNumero) {
		this.cartPromotor = cartNumero;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
}
