package med.voll.apimedic.repository;

import med.voll.apimedic.entities.MedicoEntity;
import med.voll.apimedic.medico.MedicoCadastroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    Page<MedicoCadastroDTO> findAllByAtivoTrue(Pageable paginacao);
}
