package br.com.totemti.onboarding.model;

import br.com.totemti.onboarding.uteis.Pessoa_email.PessoaEmailPadraoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PESSOA_EMAIL")
@Getter
@Setter
public class PessoaEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PESSOA_EMAIL_SEQ_GENERATOR")
    @SequenceGenerator(name = "PESSOA_EMAIL_SEQ_GENERATOR", sequenceName = "PESSOA_EMAIL_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "ID_PESSOA_EMAIL")
    private Long id;

    @Column(name = "PEE_EMAIL")
    private String email;

    @Column(name = "PEE_EMAIL_PADRAO")
    @Enumerated(value = EnumType.STRING)
    private PessoaEmailPadraoEnum padrao;

    @JoinColumn(name = "ID_PESSOA", foreignKey = @ForeignKey(name = "PESSOA_EMAIL_FK"))
    @ManyToOne
    private Pessoa pessoa;

}
