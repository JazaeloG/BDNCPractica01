package org.uv.bdncpractica01;

import java.util.List;

public interface IDAOGeneral<T, ID>{
    public T buscarById(ID id);
    List<T> buscarAll();
    public boolean guardar(T p);
    public boolean modificar(T p);
    public boolean eliminar(T p);    
}
