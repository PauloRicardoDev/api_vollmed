package med.voll.apimedic.medico;

import med.voll.apimedic.entities.MedicoEntity;

public record MedicoListagemDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public MedicoListagemDTO(MedicoEntity medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
