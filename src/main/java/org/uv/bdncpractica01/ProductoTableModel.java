/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdncpractica01;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author omar_
 */
public abstract class ProductoTableModel<T> extends AbstractTableModel{
    protected List<T> valores;
    protected String[] columnNames = {"Clave", "Descripcion", "Precio Venta", "Precio Compra"};
    
    public ProductoTableModel(String[] columnNames, List<T> lstValores){
        this.columnNames = columnNames;
        this.valores = lstValores;
    }

    @Override
    public int getRowCount() {
        return valores.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

}
