package pl.coderslab.model;

public class Exercise extends ActiveRecord{

	public Exercise() {
		tableName = "exercise";
		setTableFieldsValue("title", "description");
	}

	@Override
	public ActiveRecord getById(int id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}
	
	

}
