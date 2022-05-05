package com.br.model;

import java.time.LocalDate;

public class CartaSimples extends ModeloCarta {
	
	private String[] campos = {"data","localLoja","enderecoLoja","nomePromotor","cartNumero","serie"
			,"identidade","nomeEmpresa","enderecoEmpresa","cnpjEmpresa","IEEmpresa"};
	
	public String[] getCampos() {
		return campos;
	}
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
	public String getcartPromotor() {
		return cartPromotor;
	}
	public void setcartPromotor(String cartNumero) {
		this.cartPromotor = cartNumero;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
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
