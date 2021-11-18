package br.com.totemti.onboarding.service;

import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaDto;
import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaFormDto;
import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, ModelMapper modelMapper) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PessoaDto> getAll(Pageable pageable){
        Page pessoaDto = pessoaRepository.findAll(pageable).map(pessoa -> modelMapper.map(pessoa, PessoaDto.class));

        return pessoaDto;
    }

    public Pessoa buscar(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa inexistente"));

        return pessoa;
    }

    public PessoaDto save(PessoaFormDto pessoaFormDto){
        Pessoa pessoa = modelMapper.map(pessoaFormDto, Pessoa.class);

        var salvarPessoa = modelMapper.map(pessoaRepository.save(pessoa), PessoaDto.class);
        return salvarPessoa;
    }
}
