package pl.coderslab.model;

public class User extends ActiveRecord {

	public User() {
		super();
		tableName = "user";
		setTableFieldsValue("username", "email", "password", "user_group_id");
	}

	public User(boolean word) {
		super();
		tableName = "user";
		setTableFieldsValueWithId("id", "username", "email", "password", "user_group_id");
	}

}
