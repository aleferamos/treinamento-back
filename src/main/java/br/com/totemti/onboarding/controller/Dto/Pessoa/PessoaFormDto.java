package br.com.totemti.onboarding.controller.Dto.Pessoa;

import br.com.totemti.onboarding.uteis.Pessoa.PessoaSexoEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaStatusEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaTipoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PessoaFormDto {

    private String nome;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data_nascimento;

    private String cpf_cnpj;

    private PessoaSexoEnum sexo;

    private String inscricao_estadual;

    private PessoaStatusEnum status;

    private PessoaTipoEnum tipo;
}
