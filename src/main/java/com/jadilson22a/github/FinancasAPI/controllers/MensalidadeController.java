package com.jadilson22a.github.FinancasAPI.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jadilson22a.github.FinancasAPI.dtos.MensalidadeDTO;
import com.jadilson22a.github.FinancasAPI.models.Mensalidade;
import com.jadilson22a.github.FinancasAPI.service.MensalidadeService;

@RestController
@RequestMapping("/mensalidade")
public class MensalidadeController {

	private MensalidadeService service;

	public MensalidadeController(MensalidadeService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody MensalidadeDTO dto) {
		try {
			Mensalidade mensalidade = new Mensalidade();
			BeanUtils.copyProperties(dto, mensalidade);
			service.salvar(mensalidade);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_CONTENT);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(
			@PathVariable Integer id, 
			@RequestBody MensalidadeDTO dto){
		try {
			Mensalidade mensalidade = new Mensalidade();
			BeanUtils.copyProperties(dto, mensalidade);
			service.salvar(id, mensalidade);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					e.getMessage(),
					HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		service.excluir(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarId(@PathVariable Integer id){
		try {
			Mensalidade mensalidadeEncontrada = service.buscarPorId(id);
			MensalidadeDTO dto = mensalidadeEncontrada.toDTO();
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> buscarId(){
		try {
			List<Mensalidade> mensalidades = service.buscarTudo();
			List<MensalidadeDTO> mensalidadesDTO = new ArrayList<>();
			
			for(Mensalidade x: mensalidades) {
				mensalidadesDTO.add(x.toDTO());
			}

			return new ResponseEntity<>(mensalidadesDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
