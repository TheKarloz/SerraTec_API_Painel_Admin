package org.serratec.service;

import java.util.List;

import org.serratec.exception.CategoriaException;
import org.serratec.model.Categoria;
import org.serratec.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        if(categoriaRepository.findAll().isEmpty()){
            throw new CategoriaException("");
        }
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new CategoriaException("Categoria com id '" + id + "' não foi encontrada"));
    }

    public Categoria buscarPorNome(String nomeCategoria){
        if(categoriaRepository.findByNome(nomeCategoria) == null){
            throw new CategoriaException("Categoria '" + nomeCategoria + "' não foi encontrada");
        }
        return categoriaRepository.findByNome(nomeCategoria);
    }

    public Categoria inserir(Categoria categoria){
        if(categoriaRepository.findByNome(categoria.getNome().toUpperCase()) != null){
            throw new CategoriaException("Categoria '" + categoria.getNome() + "' já está cadastrada");
        }
        categoria.setNome(categoria.getNome().toUpperCase());
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria, Long id){
		if(categoriaRepository.existsById(id)){
            categoria.setId(id);
            categoria.setNome(categoria.getNome().toUpperCase());
            return categoriaRepository.save(categoria);
        }   
		throw new CategoriaException("Categoria com id '" + id + "' não foi encontrada");
    }

    public void deletar(Long id){
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }else{
            throw new CategoriaException("Categoria com id '" + id + "' não foi encontrada");
        }
    }
    
}
