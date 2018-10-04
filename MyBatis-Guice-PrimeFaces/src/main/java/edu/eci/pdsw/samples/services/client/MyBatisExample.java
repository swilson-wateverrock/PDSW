/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
	public static void main(String args[]) throws SQLException {
		//Importante!!!!!!!!!! estudiar esto para el parcial.
		
		Cliente pruebaCliente = new Cliente("Willson Melo Merchan", 2133541, "3123214148", "Dimensión c-137 planeta Tierra", "swilson@randm.com");
		TipoItem pruebaTipoItem = new TipoItem(1, "Video");
		Item pruebaItem = new Item(pruebaTipoItem, 137, "Rick and Morty", "kha", new Date(9152018), 5000, "DVD", "Ficción");
		
	
	    SqlSessionFactory sessionfact = getSqlSessionFactory();
	    SqlSession sqlss = sessionfact.openSession();
	    ClienteMapper clMap = sqlss.getMapper(ClienteMapper.class);
	    ItemMapper itMap = sqlss.getMapper(ItemMapper.class);
	    ItemRentadoMapper itReMap = sqlss.getMapper(ItemRentadoMapper.class);
	    TipoItemMapper tiIMap = sqlss.getMapper(TipoItemMapper.class);
	    
	    //clMap.insertarCliente(pruebaCliente);
	    //System.out.println(clMap.consultarClientes());
	    //System.out.println(clMap.consultarCliente(2133541));
	    
	    //System.out.println(itMap.consultarItems());
	    //System.out.println(itReMap.consultarItemsRentados());
	    //System.out.println(itMap.consultarItem(137));
	    //itMap.insertItem(pruebaItem);
	    
	   
	    
	    //System.out.println(itReMap.consultarItemRentado(1));
	    
	    //System.out.println(tiIMap.consultarTiposItems());
	    //System.out.println(tiIMap.consultarTipoItem(1));
	    //tiIMap.insertTipoItem(pruebaTipoItem);//este item ya esta insertado
	   
	    
	    sqlss.commit();
	    sqlss.close();
	}


}
