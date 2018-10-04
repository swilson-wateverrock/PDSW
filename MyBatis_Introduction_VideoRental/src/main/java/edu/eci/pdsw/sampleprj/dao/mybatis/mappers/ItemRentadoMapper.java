package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

/**
 *
 * @author 2133541
 */


public interface ItemRentadoMapper {
    
	// Nos parecio mejor sacar los items rentados del cliente Mapper al fin y al cabo tiene su propio objeto
	
    /**
     * 
     * @return la consulta de todos los items rentados     */
    public List<ItemRentado> consultarItemsRentados();
    
    public ItemRentado consultarItemRentado(@Param("idItemRentado") int id);
    
    /**
	 * Registrar un nuevo item rentado asociado al cliente identificado
	 * con 'idc' y relacionado con el item identificado con 'idi'
	 * @param id
	 * @param idit
	 * @param fechainicio
	 * @param fechafin 
	 * correción
	 * @param itemrentados
	 * 
	 */
	public void insertItemRentado(ItemRentado itemRentado);

}