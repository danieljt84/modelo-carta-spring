package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.CartaAtacadao;
import com.br.model.CartaSimples;
import com.br.model.CartaSimplesSp;
import com.br.service.WordService;

@RestController(value = "/")
public class CartaController {
	
	@Autowired
	WordService wordService;
	
	@ResponseBody @PostMapping("/cartasimples")
	public ResponseEntity<?> makeCartaSimples(@RequestBody CartaSimples carta) {
		try {
			byte[] bytes = wordService.reportCartaSimples(carta);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition","attachment;filename=hero.docx");
            return ResponseEntity.ok().headers(headers).body(bytes);
		} catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
	}
	
	@ResponseBody @PostMapping("/cartasimplessp")
	public ResponseEntity<?> makeCartaSimplesSp(@RequestBody CartaSimplesSp carta) {
		try {
			byte[] bytes = wordService.reportCartaSimplesSp(carta);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition","attachment;filename=hero.docx");
            return ResponseEntity.ok().headers(headers).body(bytes);
		} catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
	}
	@ResponseBody @PostMapping("/cartaatacadao")
	public ResponseEntity<?> makeCartaAtacadao(@RequestBody CartaAtacadao carta) {
		try {
			byte[] bytes = wordService.reportCartaAtacadao(carta);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition","attachment;filename=hero.docx");
            return ResponseEntity.ok().headers(headers).body(bytes);
		} catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
	}

}
