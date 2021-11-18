package br.com.totemti.onboarding.controller.Dto.PessoaEmail;

import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.uteis.Pessoa_email.PessoaEmailPadraoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaEmailDto {

    private String email;

    private PessoaEmailPadraoEnum padrao;

    private Pessoa pessoa;
}
