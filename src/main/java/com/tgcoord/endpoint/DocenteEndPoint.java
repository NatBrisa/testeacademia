/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgcoord.endpoint;

import com.tgcoord.model.Docente;
import com.tgcoord.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * @author natal
 */
@RestController
@RequestMapping("docentes")
public class DocenteEndPoint {

	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(DocenteEndPoint.class.getName());

	private final DocenteRepository docenteDAO;

	/**
	 * @param docenteDAO
	 */
	@Autowired
	public DocenteEndPoint(DocenteRepository docenteDAO) {
		this.docenteDAO = docenteDAO;
	}

	/**
	 * @param p
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> listAll(Pageable p) {
		return new ResponseEntity<>(docenteDAO.findAll(p), HttpStatus.FOUND);
	}

	/**
	 * @param id
	 * @return
	 * @throws NoSuchElementException
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) throws NoSuchElementException {
		Docente docente = docenteDAO.findById(id).orElseThrow();
		return new ResponseEntity<>(docente, HttpStatus.FOUND);
	}

	@GetMapping("/{nome}")
	public ResponseEntity<?> getByName(@PathVariable String nome) throws NoSuchElementException {
		List<Docente> docente = docenteDAO.findByNomeIgnoreCaseContaining(nome);
		return new ResponseEntity<>(docente, HttpStatus.FOUND);
	}

	/**
	 * @param input
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Docente input) {
		docenteDAO.save(input);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * @param id
	 * @param input
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> save(@PathVariable Long id, @RequestBody Docente input) {
		return new ResponseEntity<>(docenteDAO.save(input), HttpStatus.CREATED);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		docenteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 *
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
	public void handleError() {
	}

}
