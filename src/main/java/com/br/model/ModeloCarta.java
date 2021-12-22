package com.br.model;

import java.time.LocalDate;

public abstract class ModeloCarta{
	
	LocalDate data;
	String localLoja;
	String enderecoLoja;
	String nomePromotor;
	String cartPromotor;
	Integer serie;
	String identidade;
	String nomeEmpresa;
	String cpf;
	String empresaContratante;
	
	private String getCartPromotor() {
		return cartPromotor;
	}
	private void setCartPromotor(String cartPromotor) {
		this.cartPromotor = cartPromotor;
	}
	private String getCpf() {
		return cpf;
	}
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private String getEmpresaContratante() {
		return empresaContratante;
	}
	private void setEmpresaContratante(String empresaContratante) {
		this.empresaContratante = empresaContratante;
	}
	private LocalDate getData() {
		return data;
	}
	private void setData(LocalDate data) {
		this.data = data;
	}
	private String getLocalLoja() {
		return localLoja;
	}
	private void setLocalLoja(String localLoja) {
		this.localLoja = localLoja;
	}
	private String getEnderecoLoja() {
		return enderecoLoja;
	}
	private void setEnderecoLoja(String enderecoLoja) {
		this.enderecoLoja = enderecoLoja;
	}
	private String getNomePromotor() {
		return nomePromotor;
	}
	private void setNomePromotor(String nomePromotor) {
		this.nomePromotor = nomePromotor;
	}
	private String getcartPromotor() {
		return cartPromotor;
	}
	private void setcartPromotor(String cartNumero) {
		this.cartPromotor = cartNumero;
	}
	private Integer getSerie() {
		return serie;
	}
	private void setSerie(Integer serie) {
		this.serie = serie;
	}
	private String getIdentidade() {
		return identidade;
	}
	private void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	private String getNomeEmpresa() {
		return nomeEmpresa;
	}
	private void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	private void setData() {		
	}
}
