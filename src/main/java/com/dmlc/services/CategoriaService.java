package com.dmlc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmlc.domain.Categoria;
import com.dmlc.repositories.CategoriaRepository;
import com.dmlc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id +", Tipo: " + Categoria.class.getName()));	
	}
	
	public List<Categoria> list(){
		List<Categoria> list = repo.findAll();
		return list;
	}
}
