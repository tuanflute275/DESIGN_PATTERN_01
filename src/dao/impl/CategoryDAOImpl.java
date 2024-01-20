package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.GeneralDAO;
import db.JDBCUtil;
import entities.Category;

public class CategoryDAOImpl implements GeneralDAO<Category> {

	private List<Category> data;
	
	private static CategoryDAOImpl instance; 
	
	private CategoryDAOImpl() {}

	public static CategoryDAOImpl getInstance() {
		if(instance == null) 
			instance = new CategoryDAOImpl();
		return instance;
	}

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<Category> get() {
		data = new ArrayList<Category>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Category> getByName(String name) {
		data = new ArrayList<Category>();
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category WHERE name LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				data.add(new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Category findId(Integer id) {
		try {
			conn = JDBCUtil.getConnection();
			String sql = "SELECT * FROM category WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Category(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Category entity) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "INSERT INTO category(id, name, status) VALUES (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, entity.getId());
			ps.setString(2, entity.getName());
			ps.setBoolean(3, entity.isStatus());
			
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean edit(Category entity) {
		boolean kq = false;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "UPDATE category SET name=?,status=? WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setBoolean(2, entity.isStatus());
			ps.setInt(3, entity.getId());
			
			int i = ps.executeUpdate();
			if(i > 0)
				kq = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public boolean remove(Category entity) {
		boolean kq = false;
		try {
			String sql = "DELETE FROM category WHERE ID = ?";
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
