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
package edu.eci.pdsw.webappsintro.jdbc.example.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
        	String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="bdprueba";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            System.out.println("Valor total pedido 1: "+valorTotalPedido(con, 2));
            
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2133541;
            registrarNuevoProducto(con, suCodigoECI, "Willson Melo", 99999999);            
            con.commit();
            
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        //Asignar parámetros
        //usar 'execute'
    	
    	PreparedStatement insertProduct = null;
    	/* esta opción también funiona.
    	String insertString = "insert into bdprueba.ORD_PRODUCTOS (codigo,nombre,precio) VALUES "
    			+ "("+ Integer.toString(codigo)+","+nombre+","+Integer.toString(precio)+")" ;*/
    	
    	//La mejor forma de hacerlo.
    	String insertString = "insert into bdprueba.ORD_PRODUCTOS (codigo,nombre,precio) VALUES (?,?,?)";
    	insertProduct = con.prepareStatement(insertString);
    	insertProduct.setInt(1, codigo);
    	insertProduct.setString(2,nombre);
    	insertProduct.setInt(3, precio);
    	insertProduct.execute();
        con.commit();
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido){
        List<String> np=new LinkedList<>();
        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla
        PreparedStatement selectProductsName = null;
        String stringSelectProductName = "SELECT OP.nombre FROM bdprueba.ORD_PRODUCTOS OP WHERE"
        		+" OP.codigo in (select producto_fk from bdprueba.ORD_DETALLES_PEDIDO ODP "
        		+ "WHERE ODP.pedido_fk = ? )";
        
        
        try {
        	selectProductsName = con.prepareStatement(stringSelectProductName);
			selectProductsName.setInt(1, codigoPedido);
			ResultSet select = selectProductsName.executeQuery();
			con.commit();
			
			while( select.next() ) {
				np.add(select.getString("nombre"));
			}
		} catch (SQLException e) {
			System.out.println("algo salio mal");
			e.printStackTrace();
		}
        
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido){
        
        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultado del ResultSet
    	int result = 0;
    	PreparedStatement selectTotalPedido = null;
    	String stringSelectPedido = "select sum(bdprueba.ORD_PRODUCTOS.precio*bdprueba.ORD_DETALLES_PEDIDO.cantidad)"
    			+ " from bdprueba.ORD_PRODUCTOS "
    			+ "INNER JOIN bdprueba.ORD_DETALLES_PEDIDO ON bdprueba.ORD_PRODUCTOS.codigo = bdprueba.ORD_DETALLES_PEDIDO.producto_fk "
    			+ "WHERE bdprueba.ORD_DETALLES_PEDIDO.pedido_fk = ? ";
    	try {
			selectTotalPedido = con.prepareStatement(stringSelectPedido);
			selectTotalPedido.setInt(1,codigoPedido);
			ResultSet select = selectTotalPedido.executeQuery();
			select.next();
			result = select.getInt(1);
			
			
		} catch (SQLException e) {
			System.out.println("algo salio mal 2");
			e.printStackTrace();
		}
    	
    			
        
        return result;
    }
    

    
    
    
}
