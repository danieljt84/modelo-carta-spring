package com.br.model;

public class CartaSimples extends ModeloCarta {
	
	private String[] campos = {"data","localLoja","enderecoLoja","nomePromotor","cartNumero","serie"
			,"identidade","nomeEmpresa","enderecoEmpresa","cnpjEmpresa","IEEmpresa"};
	
	public String[] getCampos() {
		return campos;
	}
}
