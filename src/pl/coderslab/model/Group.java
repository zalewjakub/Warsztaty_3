package pl.coderslab.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group extends ActiveRecord {

	public Group() {
		super();
		tableName = "user_group";
		setTableFieldsValue("name");
	}
	public Group(boolean word) {
		super();
		tableName = "user_group";
		setTableFieldsValueWithId("id", "name");
	}

}
