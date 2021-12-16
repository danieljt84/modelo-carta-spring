package com.br.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import com.br.model.CartaSimples;
import com.br.model.ModeloCarta;

@Service
public class WordService {

	public byte[] reportCartaSimples(CartaSimples carta) {
		try {
			XWPFDocument doc = switchModeloCarta(carta.getNomeEmpresa());
			for (XWPFParagraph p : doc.getParagraphs()) {
				List<XWPFRun> runs = p.getRuns();
				if (runs != null) {
					for (XWPFRun r : runs) {
						String text = r.getText(0);
						if (text != null && text.contains("dia")) {
							text = text.replace("dia",String.valueOf(carta.getData().getDayOfMonth()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("mes")) {
							text = text.replace("mes",String.valueOf(carta.getData().getMonth()));
							r.setText(text, 0);
						}
						if (text != null && text.contains("ano")) {
							text = text.replace("ano",String.valueOf(carta.getData().getYear()));
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
						if (text != null && text.contains("cartNumero")) {
							text = text.replace("cartNumero", String.valueOf(carta.getCartNumero()));
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
			return null;
		}
	}

	public XWPFDocument switchModeloCarta(String nomeEmpresa) throws InvalidFormatException, IOException {
		XWPFDocument doc = null;
		Path currentRelativePath = Paths.get("");

		switch (nomeEmpresa) {
		case "A MULTI MERCHAN LTDA":
			 doc = new XWPFDocument(
					OPCPackage.open(currentRelativePath.toAbsolutePath().toString()+"/resources/CARTA-MULTI MERCHAN.docx"));
			break;
		case "CRIART CRIACOES PROMOCIONAIS EIRELI":
			 doc = new XWPFDocument(OPCPackage.open(currentRelativePath.toAbsolutePath().toString()+"/resources/CARTA-CRIART.docx"));
             
			break;
		case "PINCELART SERVICOS PROMOCIONAIS EIRELI":
			doc = new XWPFDocument(OPCPackage.open(currentRelativePath.toAbsolutePath().toString()+"/resources/CARTA-PINCELART.docx"));
			break;
		case "4P PROMOCOES E EVENTOS":
			doc = new XWPFDocument(
					OPCPackage.open(currentRelativePath.toAbsolutePath().toString()+"/resources/CARTA-4P PROMOÇÕES.docx"));
			break;
		}
		return doc;
	}
}
