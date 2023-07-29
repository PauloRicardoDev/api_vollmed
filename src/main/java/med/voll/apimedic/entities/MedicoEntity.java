package med.voll.apimedic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.apimedic.medico.MedicoAtualizacaoDTO;
import med.voll.apimedic.medico.MedicoCadastroDTO;
import med.voll.apimedic.medico.Especialidade;
@Table(name = "tb_medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private EnderecoEntity endereco;

    private Boolean ativo;

    public MedicoEntity(MedicoCadastroDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new EnderecoEntity(dados.endereco());
        this.ativo = true;
    }

    public void atualizarinfos(MedicoAtualizacaoDTO dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.nome = dados.telefone();
        }
        if (dados.enderecoDTO() != null){
            this.endereco.atualizaInfos(dados.enderecoDTO());
        }
    }

    public void inativa() {
        this.ativo = false;
    }
}
