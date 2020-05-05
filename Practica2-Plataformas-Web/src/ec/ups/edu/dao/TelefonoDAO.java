package ec.ups.edu.dao;

 

 

import java.util.List;

 

import ec.ups.edu.modelo.Telefono;

 

public interface TelefonoDAO extends GenericDAO<Telefono, Integer> {

 

    public abstract List<Telefono> findByPersonaId(String cedula);

 

}