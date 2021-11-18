package br.com.totemti.onboarding.uteis.Pessoa;

public enum PessoaStatusEnum {

    A("Ativo"),
    I("Inativo");

    private String status;

    PessoaStatusEnum(String status){
        this.status = status;
    }
}
