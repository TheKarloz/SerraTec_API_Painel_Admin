package org.serratec.repository;

import org.serratec.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public Cliente findByEmail(String email);
    public Cliente findByCpf(String cpf);
}
