package br.com.totemti.onboarding.repository;

import br.com.totemti.onboarding.controller.Dto.PessoaEmail.PessoaEmailDto;
import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.model.PessoaEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaEmailRepository extends JpaRepository<PessoaEmail, Long> {

    Optional<Page<PessoaEmail>> findByPessoa (Pessoa pessoa, Pageable pageable);
}
