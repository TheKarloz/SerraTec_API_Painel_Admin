package org.serratec.service;

import java.util.List;

import org.serratec.exception.EmailException;
import org.serratec.model.Categoria;
import org.serratec.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar (Categoria categoria, Long id) {
		if(categoriaRepository.existsById(id)){
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }   
		return null;
    }



}
