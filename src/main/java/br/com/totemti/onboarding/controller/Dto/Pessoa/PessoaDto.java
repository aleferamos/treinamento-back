package br.com.totemti.onboarding.controller.Dto.Pessoa;


import br.com.totemti.onboarding.uteis.Pessoa.PessoaSexoEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaStatusEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaTipoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaDto {

    private Long id;

    private String nome;

    private LocalDate data_nascimento;

    private String cpf_cnpj;

    private PessoaSexoEnum sexo;

    private String inscricao_estadual;

    private PessoaStatusEnum status;

    private PessoaTipoEnum tipo;
}
