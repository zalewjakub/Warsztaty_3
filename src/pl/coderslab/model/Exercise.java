package pl.coderslab.model;

public class Exercise extends ActiveRecord{

	public Exercise() {
		tableName = "exercise";
		setTableFieldsValue("title", "description");
	}
	
	

}
