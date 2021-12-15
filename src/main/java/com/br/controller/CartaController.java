package com.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.CartaSimples;
import com.br.service.WordService;

@RestController(value = "/")
public class CartaController {
	
	@Autowired
	WordService wordService;
	
	@ResponseBody @PostMapping
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

}