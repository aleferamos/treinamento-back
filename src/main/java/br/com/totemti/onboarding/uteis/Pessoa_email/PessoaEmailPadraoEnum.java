package br.com.totemti.onboarding.uteis.Pessoa_email;

public enum PessoaEmailPadraoEnum {

    S("Sim"),
    N("Não");

    private String padrao;

    PessoaEmailPadraoEnum(String padrao){
        this.padrao = padrao;
    }
}
