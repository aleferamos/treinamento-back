package br.com.totemti.onboarding.uteis.Pessoa;

public enum PessoaSexoEnum {

    M("Masculino"),
    F("Femenino"),
    O("Outro");

    private String sexo;

    PessoaSexoEnum(String sexo){
        this.sexo = sexo;
    }
}
