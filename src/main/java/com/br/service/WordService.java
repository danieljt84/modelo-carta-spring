package com.br.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import com.br.model.CartaAtacadao;
import com.br.model.CartaSimples;
import com.br.model.CartaSimplesSp;
import com.br.model.ModeloCarta;

@Service
public class WordService {

	public byte[] reportCartaSimplesSp(CartaSimplesSp carta) throws Exception {
		try {
			XWPFDocument doc = switchModeloCartaSimplesSp(carta.getNomeEmpresa());
			for (XWPFParagraph p : doc.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("enderecoLoja")) {
							text = text.replace("enderecoLoja", carta.getEnderecoLoja());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomePromotor")) {
							text = text.replace("nomePromotor", carta.getNomePromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("cart")) {
							text = text.replace("cart", carta.getcartPromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("serie")) {
							text = text.replace("serie", carta.getSerie().toString());
							r.setText(text, 0);
						}
						if (text != null && text.contains("identidade")) {
							text = text.replace("identidade", carta.getIdentidade());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomeEmpresa")) {
							text = text.replace("nomeEmpresa", carta.getNomeEmpresa());
							r.setText(text, 0);
						}
						if (text != null && text.contains("cpf")) {
							text = text.replace("cpf", carta.getCpf());
							r.setText(text, 0);
						}
						if (text != null && text.contains("empresaContratante")) {
							text = text.replace("empresaContratante", carta.getEmpresaContratante());
							r.setText(text, 0);
						}
					}
				}
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			doc.write(outputStream);
			return outputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public byte[] reportCartaSimples(CartaSimples carta) throws Exception {
		try {
			XWPFDocument doc = switchModeloCartaSimples(carta.getNomeEmpresa());
			for (XWPFParagraph p : doc.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("dia")) {
							text = text.replace("dia", String.valueOf(carta.getData().getDayOfMonth()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("mes")) {
							text = text.replace("mes", convertMonth(carta.getData().getMonth()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("ano")) {
							text = text.replace("ano", String.valueOf(carta.getData().getYear()));
							r.setText(text, 0);
						}
						
						if (text != null && text.contains("localLoja")) {
							text = text.replace("localLoja", carta.getLocalLoja());
							r.setText(text, 0);
						}
						if (text != null && text.contains("enderecoLoja")) {
							text = text.replace("enderecoLoja", carta.getEnderecoLoja());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomePromotor")) {
							text = text.replace("nomePromotor", carta.getNomePromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("cart")) {
							text = text.replace("cart", carta.getcartPromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("serie")) {
							text = text.replace("serie", carta.getSerie().toString());
							r.setText(text, 0);
						}
						if (text != null && text.contains("identidade")) {
							text = text.replace("identidade", carta.getIdentidade());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomeEmpresa")) {
							text = text.replace("nomeEmpresa", carta.getNomeEmpresa());
							r.setText(text, 0);
						}
					}
				}
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			doc.write(outputStream);
			return outputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public byte[] reportCartaAtacadao(CartaAtacadao carta) throws Exception {
		try {
			XWPFDocument doc = switchModeloCartaAtacadao(carta.getNomeEmpresa());
			for (XWPFParagraph p : doc.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("data")) {
							text = text.replace("data", carta.getData().getDayOfMonth()+" de " +convertMonth(carta.getData().getMonth())+" de "+carta.getData().getYear());
							r.setText(text, 0);
						}
						if (text != null && text.contains("localLoja")) {
							text = text.replace("localLoja", carta.getLocalLoja());
							r.setText(text, 0);
						}
						if (text != null && text.contains("enderecoLoja")) {
							text = text.replace("enderecoLoja", carta.getEnderecoLoja());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomePromotor")) {
							text = text.replace("nomePromotor", carta.getNomePromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("cart")) {
							text = text.replace("cart", carta.getCartPromotor());
							r.setText(text, 0);
						}
						if (text != null && text.contains("serie")) {
							text = text.replace("serie", carta.getSerie().toString());
							r.setText(text, 0);
						}
						if (text != null && text.contains("identidade")) {
							text = text.replace("identidade", carta.getIdentidade());
							r.setText(text, 0);
						}
						if (text != null && text.contains("nomeEmpresa")) {
							text = text.replace("nomeEmpresa", carta.getNomeEmpresa());
							r.setText(text, 0);
						}
						if (text != null && text.contains("estado")) {
							text = text.replace("estado", carta.getEstado());
							r.setText(text, 0);
						}
						if (text != null && text.contains("cpf")) {
							text = text.replace("cpf", carta.getCpf());
							r.setText(text, 0);
						}
						if (text != null && text.contains("empresaContratante")) {
							text = text.replace("empresaContratante", carta.getEmpresaContratante());
							r.setText(text, 0);
						}
					}
				}
			}
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			doc.write(outputStream);
			return outputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public XWPFDocument switchModeloCartaSimples(String nomeEmpresa) throws InvalidFormatException, IOException {
		XWPFDocument doc = null;
		Path currentRelativePath = Paths.get("");

		switch (nomeEmpresa) {
		case "A MULTI MERCHAN LTDA":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA-MULTI MERCHAN.docx"));
			break;
		case "CRIART CRIACOES PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(
					OPCPackage.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA-CRIART.docx"));

			break;
		case "PINCELART SERVICOS PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA-PINCELART.docx"));
			break;
		case "4P PROMOCOES E EVENTOS":
			doc = new XWPFDocument(
					OPCPackage.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA-4P.docx"));
			break;
		case "MKT":
			doc = new XWPFDocument(
					OPCPackage.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA-MKT.docx"));
			break;
		}
		return doc;
	}

	public XWPFDocument switchModeloCartaSimplesSp(String nomeEmpresa) throws InvalidFormatException, IOException {
		XWPFDocument doc = null;
		Path currentRelativePath = Paths.get("");

		switch (nomeEmpresa) {
		case "A MULTI MERCHAN LTDA":
			doc = new XWPFDocument(OPCPackage.open(currentRelativePath.toAbsolutePath().toString()
					+ "/resources/CARTA SIMPLES SP-MULTI MERCHAN.docx"));
			break;
		case "CRIART CRIACOES PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA SIMPLES SP-CRIART.docx"));

			break;
		case "PINCELART SERVICOS PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage.open(
					currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA SIMPLES SP-PINCELART.docx"));
			break;
		case "4P PROMOCOES E EVENTOS":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA SIMPLES SP-4P.docx"));
			break;
		case "MKT":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA SIMPLES SP-MKT.docx"));
			break;
		}
		return doc;
	}

	public XWPFDocument switchModeloCartaAtacadao(String nomeEmpresa) throws InvalidFormatException, IOException {
		XWPFDocument doc = null;
		Path currentRelativePath = Paths.get("");

		switch (nomeEmpresa) {
		case "A MULTI MERCHAN LTDA":
			doc = new XWPFDocument(OPCPackage.open(
					currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA ATACADAO-MULTI MERCHAN.docx"));
			break;
		case "CRIART CRIACOES PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA ATACADAO-CRIART.docx"));

			break;
		case "PINCELART SERVICOS PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage.open(
					currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA ATACADAO-PINCELART.docx"));
			break;
		case "4P PROMOCOES E EVENTOS":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA ATACADAO-4P.docx"));
			break;
		case "MKT":
			doc = new XWPFDocument(OPCPackage
					.open(currentRelativePath.toAbsolutePath().toString() + "/resources/CARTA ATACADAO-MKT.docx"));
			break;
		}
		return doc;
	}
	
	public String convertMonth(Month month){
		switch(month) {
		case JANUARY:
			return "Janeiro";
		case FEBRUARY:
			return "Fevereiro";
		case MARCH:
			return "Março";
		case APRIL:
			return "Abril";
		case MAY:
			return "Maio";
		case JUNE:
			return "Junho";
		case JULY:
			return "Julho";
		case AUGUST:
			return "Agosto";
		case SEPTEMBER:
			return "Setembro";
		case OCTOBER:
			return "Outubro";
		case NOVEMBER:
			return "Novembro";
		case DECEMBER:
			return "Dezembro";
		default:
			return null;
		}
	}
}
