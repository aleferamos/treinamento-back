package br.com.totemti.onboarding.uteis.Pessoa;

public enum PessoaTipoEnum {

    F("Fisica"),
    J("Juridica");

    private String tipo;

    PessoaTipoEnum(String tipo){
        this.tipo = tipo;
    }
}
