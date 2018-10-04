package edu.eci.pdsw.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.pdsw.samples.entities.TipoItem;

public interface TipoItemDAO {
	
	
	public void save(TipoItem tipIT) throws PersistenceException;

	public TipoItem load(int IdTipIt) throws PersistenceException;
}
