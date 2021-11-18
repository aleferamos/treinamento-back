package br.com.totemti.onboarding.model;

import br.com.totemti.onboarding.uteis.Pessoa.PessoaSexoEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaStatusEnum;
import br.com.totemti.onboarding.uteis.Pessoa.PessoaTipoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PESSOA")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PESSOA_SEQ_GENERATOR")
    @SequenceGenerator(name = "PESSOA_SEQ_GENERATOR", sequenceName = "PESSOA_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "PES_NOME")
    private String nome;

    @Column(name = "PES_NASCIMENTO")
    private LocalDate data_nascimento;

    @Column(name = "PES_CPF_CNPJ")
    private String cpf_cnpj;

    @Column(name = "PES_SEXO")
    @Enumerated(value = EnumType.STRING)
    private PessoaSexoEnum sexo;

    @Column(name = "PES_INSCRICAO_ESTADUAL")
    private String inscricao_estadual;

    @Column(name = "PES_ATIVO")
    @Enumerated(value = EnumType.STRING)
    private PessoaStatusEnum status;

    @Column(name = "PES_TIPO")
    @Enumerated(value = EnumType.STRING)
    private PessoaTipoEnum tipo;


}
