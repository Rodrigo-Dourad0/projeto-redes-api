package com.projetoredes.api.clientes.Cliente.repository;

import com.projetoredes.api.clientes.Cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}