package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Cliente;

/**
 *
 * @author 2133541
 */
public interface ClienteMapper {

	public Cliente consultarCliente(@Param("idCliente") int id); 
	
	/**
	 * Consultar todos los clientes
	 * @return 
	 */
	public List<Cliente> consultarClientes();
	
	public void insertarCliente(Cliente cliente);

}