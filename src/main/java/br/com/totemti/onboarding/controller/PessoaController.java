package br.com.totemti.onboarding.controller;

import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaDto;
import br.com.totemti.onboarding.controller.Dto.Pessoa.PessoaFormDto;
import br.com.totemti.onboarding.model.Pessoa;
import br.com.totemti.onboarding.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class PessoaController {

    private PessoaService pessoaService;
    private ModelMapper modelMapper;

    @Autowired
    public PessoaController(PessoaService pessoaService, ModelMapper modelMapper) {
        this.pessoaService = pessoaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<PessoaDto>> listar(@PageableDefault(size = Integer.MAX_VALUE) Pageable pageable){
        return ResponseEntity.ok(pessoaService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> buscar(@PathVariable Long id){
        PessoaDto pessoaDto = modelMapper.map(pessoaService.buscar(id), PessoaDto.class);
        return ResponseEntity.ok(pessoaDto);
    }

    @PostMapping
    public ResponseEntity<PessoaDto> salvar(@RequestBody PessoaFormDto pessoaFormDto){
        return ResponseEntity.ok(pessoaService.save(pessoaFormDto));
    }
}
