package pl.coderslab.model;

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
