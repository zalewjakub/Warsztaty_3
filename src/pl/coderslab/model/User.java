package pl.coderslab.model;

public class User extends ActiveRecord {

	public User() {
		super();
		tableName = "user";
		setTableFieldsValue("username", "email", "password", "user_group_id");
	}

}
