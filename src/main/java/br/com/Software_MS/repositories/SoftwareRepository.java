package br.com.Software_MS.repositories;

import br.com.Software_MS.entities.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
    boolean existsByNomeAndVersao(String nome, String versao);
}
