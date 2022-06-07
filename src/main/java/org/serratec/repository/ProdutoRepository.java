package org.serratec.repository;

import org.serratec.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    @Query("SELECT prod.categoria.id FROM Produto prod WHERE categoria.id = :id")
    public Produto procuraCategoria(Long id);
}
