package com.wizeline.onsite.repositories;

import com.wizeline.onsite.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository  extends CrudRepository<UsuarioModel, Long> {

    public abstract List<UsuarioModel> findByPrioridad(Integer prioridad);

    public abstract List<UsuarioModel> deleteById(Integer prioridad);
}
