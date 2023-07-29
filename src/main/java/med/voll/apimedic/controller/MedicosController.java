package med.voll.apimedic.controller;

import jakarta.validation.Valid;
import med.voll.apimedic.entities.MedicoEntity;
import med.voll.apimedic.medico.MedicoAtualizacaoDTO;
import med.voll.apimedic.medico.MedicoCadastroDTO;
import med.voll.apimedic.medico.MedicoListagemDTO;
import med.voll.apimedic.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoCadastroDTO dados){
       repository.save(new MedicoEntity(dados));
    }

    //com paginação
    @GetMapping
    public Page<MedicoListagemDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
//        return repository.findAll(paginacao).map(MedicoListagemDTO::new);
        return repository.findAllByAtivoTrue(paginacao).map(MedicoListagemDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid MedicoAtualizacaoDTO dados){
        MedicoEntity medico = repository.getReferenceById(dados.id());
        medico.atualizarinfos(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        MedicoEntity medico = repository.getReferenceById(id);
        medico.inativa();
    }

}
