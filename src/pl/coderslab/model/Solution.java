package pl.coderslab.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution extends ActiveRecord {
	public Solution() {
		super();
		tableName = "solution";
		setTableFieldsValue("created", "updated", "description", "exercise_id, user_id");
	}

	public Solution(boolean word) {
		super();
		tableName = "solution";
		setTableFieldsValueWithId("id", "created", "updated", "description", "exercise_id", "user_id");
	}

	@Override
	public ArrayList<String> loadAllResult(int id) {
		ArrayList<String> datas = new ArrayList<String>();
		try {

			String sql = String.format("SELECT * FROM %s WHERE user_id = %s ORDER BY updated DESC", tableName, id);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				for (String fieldName : tableFieldsValuesWithId.keySet()) {
					tableFieldsValuesWithId.put(fieldName, result.getString(fieldName));
				}
				for (String key : this.getFieldsWithId()) {
					datas.add(this.getValueWithId(key));
				}
				countRecord++;
			}
			this.countRecord = countRecord;
			return datas;
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<String>();
		}
	}

}
