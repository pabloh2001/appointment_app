package com.project.citasapp.persistence.crud;

import com.project.citasapp.persistence.entity.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MedicoCrudRepository extends CrudRepository<Medico, String> {
    List<Medico> findByIdEspecialidadOrderByNombreCompletoAsc(long especialidad);
}
