package com.maxima.avaliacao.repositories;

import com.maxima.avaliacao.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCnpj(String cnpj);

    @Query("FROM Cliente c " +
            "WHERE LOWER(c.nome) like %:searchTerm% " +
            "OR LOWER(c.cnpj) like %:searchTerm%")
    Page<Cliente> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}
