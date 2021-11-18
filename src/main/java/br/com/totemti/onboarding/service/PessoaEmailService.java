package br.com.totemti.onboarding.service;

import br.com.totemti.onboarding.controller.Dto.PessoaEmail.PessoaEmailDto;
import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.model.PessoaEmail;
import br.com.totemti.onboarding.repository.PessoaEmailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaEmailService {

    private PessoaEmailRepository pessoaEmailRepository;
    private ModelMapper modelMapper;
    private PessoaService pessoaService;

    @Autowired
    public PessoaEmailService(PessoaEmailRepository pessoaEmailRepository, ModelMapper modelMapper, PessoaService pessoaService) {
        this.pessoaEmailRepository = pessoaEmailRepository;
        this.modelMapper = modelMapper;
        this.pessoaService = pessoaService;
    }

    public Page<PessoaEmail> listar(Pessoa pessoa, Pageable pageable){
        Page pessoaDto = pessoaEmailRepository.findByPessoa(pessoa, pageable).orElseThrow(()-> new IllegalArgumentException("Email não existe"));
        return pessoaDto;
    }

    public PessoaEmail save(PessoaEmail pessoaEmail, Long id){
        Pessoa pessoa = pessoaService.buscar(id);

        pessoaEmail.setPessoa(pessoa);
        PessoaEmail pessoaSalvar = pessoaEmailRepository.save(pessoaEmail);
        return pessoaEmail;
    }

    public PessoaEmail buscar(Long id){
        return pessoaEmailRepository.getById(id);
    }
}
