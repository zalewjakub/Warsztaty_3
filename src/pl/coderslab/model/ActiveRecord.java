package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class ActiveRecord {
	protected String id = "0";
	protected String tableName = "";
	protected HashMap<String, String> tableFieldsValues = new HashMap<>();
	protected ArrayList<String> displayOrder = new ArrayList<>();
	protected Connection conn = null;

	public ActiveRecord() {
		try {
			conn = DbUtil.getConn();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	protected void setTableFieldsValue(String... fieldNames) {
		for (String name : fieldNames) {
			displayOrder.add(name);
			tableFieldsValues.put(name, ""); 
		}
	}

	public String getTableName() {
		return tableName;
	}

	public String getValue(String key) { // ten geter jest potrzebny aby przetestwować w TestUser metodę getById.
		return tableFieldsValues.get(key);

	}

	public void setValue(String key, String value) {
		if (tableFieldsValues.containsKey(key)) {
			tableFieldsValues.put(key, value);
		} else {
			throw new RuntimeException(String.format("%s is not present in %s fields", key, tableName));
		}
	}

	public String[] getFields() {
		String[] tmp = new String[tableFieldsValues.size()];
		return displayOrder.toArray(tmp);
	}

	public ArrayList<String> loadAll(int limit) {
		ArrayList<String> datas = new ArrayList<String>();
		try {
			String sql = String.format("SELECT * FROM %s LIMIT %s", tableName, limit);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
//			result.next();
			while(result.next()) {
			for (String fieldName : tableFieldsValues.keySet()) {
				tableFieldsValues.put(fieldName, result.getString(fieldName));				
			}
			
			for (String key : this.getFields()) {
				datas.add(this.getValue(key));
			}
			System.out.println(datas.toString());
			}
			return datas;// zwracamy cały ActiveRecord
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<String>(); // zwracamy pusty obiekt
		}
		
	}
	
	public ActiveRecord getById(int id) {
		try {
			String sql = String.format("SELECT * FROM %s WHERE id = ?", tableName);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			result.next();
			for (String fieldName : tableFieldsValues.keySet()) {
				tableFieldsValues.put(fieldName, result.getString(fieldName));
			}
			return this;// zwracamy cały ActiveRecord
		} catch (SQLException e) {
			System.out.println(e);
			return new ActiveRecord(); // zwracamy pusty obiekt
		}

	}

	private String TrimBrackets(String text) {
    	if(text.indexOf('[') == 0 && text.indexOf(']') == text.length()-1) {
    		return text.substring(1, text.length()-1);
    	}
    	return text;
    }    

    private String quotationMarks() {
    	String result = "";
    	for(String name:displayOrder) {
    		result += "?,";
    		
    	}
    	return result.substring(0, result.length()-1);
    }
	
	protected void createNew() {
		String sql = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, TrimBrackets(displayOrder.toString()),
				quotationMarks());
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			int index = 1;
			for (String field : displayOrder) {		
				stmt.setString(index++, getValue(field));
			}
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Wypełnij wszystkie pola");
		}
	}

	
	
	
	
	public void save() {
		if (id.equals("0")) {
			createNew();
		} else {
			
			String sql = "UPDATE %s SET username=?, email=?, password=? where id = %s";
			PreparedStatement preparedStatement;
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, this.username);
			preparedStatement.setString(2, this.email);
			preparedStatement.setString(3, this.password);
			preparedStatement.setInt(4, this.id);
			preparedStatement.executeUpdate();
		}
	}
}
