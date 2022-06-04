package org.serratec.repository;

import java.util.Optional;

import org.serratec.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    public Optional<Endereco> findByCep(String cep);
}
