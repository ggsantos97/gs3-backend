package com.gs3.avaliacao.junior.gs3backend.repository;

import com.gs3.avaliacao.junior.gs3backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findNomeAndCpfById(Long id);
}
