/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author 2133541
 */
public class ItemRentado implements Serializable {

    private int id;
    private Cliente cliente;
    private Item item;
    private Date fechaInicioRenta;
    private Date fechaFinRenta;

    public ItemRentado(int id, Cliente cliente, Item item, Date fechainiciorenta, Date fechafinrenta) {
        this.id = id;
        this.item = item;
        this.cliente = cliente;
        this.fechaInicioRenta = fechainiciorenta;
        this.fechaFinRenta = fechafinrenta;
    }

    public ItemRentado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getFechainiciorenta() {
        return fechaInicioRenta;
    }

    public void setFechainiciorenta(Date fechainiciorenta) {
        this.fechaInicioRenta = fechainiciorenta;
    }

    public Date getFechafinrenta() {
        return fechaFinRenta;
    }

    public void setFechafinrenta(Date fechafinrenta) {
        this.fechaFinRenta = fechafinrenta;
    }

    @Override
    public String toString() {
        return "ItemRentado{" + "id=" + id + ", item=" + item + ", fechaInicioRenta=" + fechaInicioRenta + ", fechaFinRenta=" + fechaFinRenta + "}";
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    
    
}