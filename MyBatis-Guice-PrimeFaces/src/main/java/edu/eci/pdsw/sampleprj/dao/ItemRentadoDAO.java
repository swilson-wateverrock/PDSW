package edu.eci.pdsw.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
	
	public void save(ItemRentado ItRen) throws PersistenceException;

	public ItemRentado load(int IdItRen) throws PersistenceException;
}
