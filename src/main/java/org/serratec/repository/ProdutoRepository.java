package org.serratec.repository;

import java.util.List;

import org.serratec.model.Categoria;
import org.serratec.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    public List<Produto> findByCategoria(Categoria categoria);
}
