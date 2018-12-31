package com.mtc.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mtc.app.vo.Product;

public class ProductDAO extends BaseDAO implements IProductDAO{

	private static final String SELECT_QUERY = "select * from test.product";
	private static final String INSERT_QUERY = "Insert into test.product(name,price,description,quantity) values(?,?,?,?)";
	private static final String UPDATE_QUERY = "Update test.product SET name = ?, price = ?, description = ?, quantity = ? WHERE id = ?";
	private static final String SELECT_QUERY_BY_ID = "select * from test.product where id = ?";

	
	@Override
	public Product findById(int id) {
		 Product product = null;
		try(Connection connection = getConnection()){
	    	
	    	PreparedStatement ps = connection.prepareStatement(SELECT_QUERY_BY_ID);
	    	ps.setInt(1, id );
	    	ResultSet resultSet = ps.executeQuery();
	    	
	    	if(resultSet.next()) {
	    		
	    		product = new Product();
	    		
	    		product.setId(resultSet.getInt("id"));
	    		product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

		return product;
	}

	@Override
	public List<Product> findAll() {
		
		List<Product> productsList = new ArrayList<>(); 
		
		try(Connection connection = getConnection()){
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
			
			while (resultSet.next()) {
				
				Product product = new Product();
				
				//transformation code
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getFloat("price"));
				product.setDescription(resultSet.getString("description"));
				product.setQuantity(resultSet.getInt("quantity"));
				
				productsList.add(product);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return productsList;
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		
    try(Connection connection = getConnection()){
    	
    	PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
    	ps.setString(1, product.getName());
    	ps.setFloat(2,product.getPrice());
    	ps.setString(3, product.getDescription());
    	ps.setInt(4,  product.getQuantity());
			
    	ps.executeUpdate();
    	
    }catch(Exception e) {
    	e.printStackTrace();
    }
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		
		try(Connection connection = getConnection()){
	    	
	    	PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
	    	ps.setString(1, product.getName());
	    	ps.setFloat(2,product.getPrice());
	    	ps.setString(3, product.getDescription());
	    	ps.setInt(4,  product.getQuantity());
	    	ps.setInt(5, product.getId());
	    					
	    	ps.executeUpdate();
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
