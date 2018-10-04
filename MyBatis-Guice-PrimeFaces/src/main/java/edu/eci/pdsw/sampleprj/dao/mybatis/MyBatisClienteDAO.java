package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;

public class MyBatisClienteDAO implements ClienteDAO {
	@Inject
	private ClienteMapper clienteMapper;
	
	@Override
	public void save(Cliente cliente) throws PersistenceException{
		try {
			clienteMapper.insertarCliente(cliente);
		}catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al registrar el cliente"+cliente.toString(), e);
		}
	}

	@Override
	public Cliente load(int idClient) throws PersistenceException {
		try {
			return clienteMapper.consultarCliente(idClient);
		} catch (Exception e) {
			throw new PersistenceException("Error al consultar el cliente"+idClient, e);

		}
		
	}
	
}
