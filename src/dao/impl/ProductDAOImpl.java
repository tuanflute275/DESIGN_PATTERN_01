package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.GenericDAO;
import db.JDBCUtil;
import entities.Category;
import entities.Product;

public class ProductDAOImpl implements GenericDAO<Product>{
	
	private List<Product> data;

	public static ProductDAOImpl getInstance() {
		return new ProductDAOImpl();
	}

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Product> get() {
		data = new ArrayList<Product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(4), rs.getBoolean(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Product> getByName(String name) {
		data = new ArrayList<Product>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product WHERE name LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(4), rs.getBoolean(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Product findId(Integer id) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM product WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getInt(4), rs.getBoolean(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product entity) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO product(id, name,price,categoryId, status) VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			ps.setString(2, entity.getName());
			ps.setDouble(3, entity.getPrice());
			ps.setInt(4, entity.getCategoryId());
			ps.setBoolean(5, entity.isStatus());
			
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean edit(Product entity) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE product SET name=?, price=?,categoryId=?,status=? WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setDouble(2, entity.getPrice());
			ps.setInt(3, entity.getCategoryId());
			ps.setBoolean(4, entity.isStatus());
			ps.setInt(5, entity.getId());
			
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean remove(Product entity) {
		boolean kq = false;
		try {
			String sql = "DELETE FROM product WHERE ID = ?";
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kq;
	}

}
