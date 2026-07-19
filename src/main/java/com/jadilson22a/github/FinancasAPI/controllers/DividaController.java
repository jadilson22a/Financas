package com.jadilson22a.github.FinancasAPI.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jadilson22a.github.FinancasAPI.dtos.DividaDTO;
import com.jadilson22a.github.FinancasAPI.models.Divida;
import com.jadilson22a.github.FinancasAPI.service.DividaService;

@RestController
@RequestMapping("/divida")
public class DividaController {

	private DividaService service;

	public DividaController(DividaService service) {
		this.service = service;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(
			@PathVariable Integer id, 
			@RequestBody DividaDTO dto){
		try {
			service.atualizar(id, dto.toDivida());
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{mensalidadeId}")
	public ResponseEntity<?> buscar(@PathVariable Integer mensalidadeId){
		try {
			List<Divida> dividas = service.buscar(mensalidadeId);
			List<DividaDTO> dividasDTO = new ArrayList<>();
			
			for(Divida x: dividas) {
				DividaDTO dto = x.toDTO();
				dividasDTO.add(dto);
			}
			
			return new ResponseEntity<>(dividasDTO, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
