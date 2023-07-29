package med.voll.apimedic.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.apimedic.endereco.EnderecoDTO;

public record MedicoAtualizacaoDTO(

        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO
) {
}
