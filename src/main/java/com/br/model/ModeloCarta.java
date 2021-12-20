package com.br.model;

import java.time.LocalDate;

public abstract class ModeloCarta{
	
	LocalDate data;
	String localLoja;
	String enderecoLoja;
	String nomePromotor;
	Long cartPromotor;
	Integer serie;
	String identidade;
	String nomeEmpresa;
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getLocalLoja() {
		return localLoja;
	}
	public void setLocalLoja(String localLoja) {
		this.localLoja = localLoja;
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
	public Long getCartPromotor() {
		return cartPromotor;
	}
	public void setCartPromotor(Long cartPromotor) {
		this.cartPromotor = cartPromotor;
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
	public void setData() {		
	}
}
