/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdncpractica01;

import java.sql.Connection;

/**
 *
 * @author omar_
 */
public abstract class TransaccionDB<T> {
    protected T pojo;
    protected TransaccionDB(T pojo){
        this.pojo=pojo;
    }
    public abstract boolean execute(Connection con);   
}
