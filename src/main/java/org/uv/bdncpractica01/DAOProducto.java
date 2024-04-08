/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdncpractica01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author omar_
 */
public class DAOProducto implements IDAOGeneral<PojoProducto, Long>{

    @Override
    public PojoProducto buscarById(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PojoProducto producto = session.get(PojoProducto.class, id);
        transaction.commit();
        return producto;
    }

    @Override
    public List<PojoProducto> buscarAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<PojoProducto> productos = session.createQuery("FROM producto", PojoProducto.class).list();
        transaction.commit();
        return productos;
    }

    @Override
    public boolean guardar(PojoProducto producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(producto);
        transaction.commit();
        return true;
    }

    @Override
    public boolean modificar(PojoProducto producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PojoProducto existingProducto = session.get(PojoProducto.class, producto.getId());
        if (existingProducto != null) {
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecioVenta(producto.getPrecioVenta());
            existingProducto.setPrecioCompra(producto.getPrecioCompra());
            session.update(existingProducto);
            transaction.commit();
            return true;
        } else {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean eliminar(PojoProducto producto) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(producto);
        transaction.commit();
        return true;
    }
    
    public List<PojoProducto> cargarTodosLosProductos() {
        try {
            return buscarAll();
        } catch (Exception e) {
            return new ArrayList<>(); 
        }
    }
}
