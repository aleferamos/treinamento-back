package br.com.totemti.onboarding.controller;

import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaDto;
import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaFormDto;
import br.com.totemti.onboarding.controller.Dto.PessoaEmail.PessoaEmailDto;
import br.com.totemti.onboarding.controller.Dto.PessoaEmail.PessoaEmailFormDto;
import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.model.PessoaEmail;
import br.com.totemti.onboarding.service.PessoaEmailService;
import br.com.totemti.onboarding.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoas/{idPessoa}/emails")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class PessoaEmailController {

    private PessoaEmailService pessoaEmailService;
    private ModelMapper modelMapper;
    private PessoaService pessoaService;

    @Autowired
    public PessoaEmailController(PessoaEmailService pessoaEmailService, ModelMapper modelMapper, PessoaService pessoaService) {
        this.pessoaEmailService = pessoaEmailService;
        this.modelMapper = modelMapper;
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<Page<PessoaEmailDto>> listar(@PathVariable(name = "idPessoa") Long idPessoa, Pageable pageable){
        Pessoa pessoa = pessoaService.buscar(idPessoa);

        Page pessoas = pessoaEmailService.listar(pessoa, pageable).map(listaPessoas -> modelMapper.map(listaPessoas, PessoaEmailDto.class));
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaEmailDto> buscar(@PathVariable Long id){
        PessoaEmailDto pessoaEmailDto = modelMapper.map(pessoaEmailService.buscar(id), PessoaEmailDto.class);

        return ResponseEntity.ok(pessoaEmailDto);
    }

    @PostMapping
    public ResponseEntity<PessoaEmailDto> salvar(@PathVariable(name = "idPessoa") Long id, @RequestBody PessoaEmailFormDto pessoaEmailFormDto){
        PessoaEmail pessoaEmail = modelMapper.map(pessoaEmailFormDto, PessoaEmail.class);
        PessoaEmailDto pessoaEmailDto = modelMapper.map(pessoaEmailService.save(pessoaEmail, id), PessoaEmailDto.class);

        return ResponseEntity.ok(pessoaEmailDto);
    }



}
