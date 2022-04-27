package com.project.appointment.persistence.crud;

import com.project.appointment.persistence.entity.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MedicoCrudRepository extends CrudRepository<Medico, String> {

}
