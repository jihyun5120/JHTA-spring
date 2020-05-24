package di_autowire;

//이름이 동일한 빈 객체를 자동 주입.
public class ByNameDao {
	DB db;

	public DB getDb() {
		return db;
	}

	//bean의 id가 db인 객체가 주입.
	public void setDb(DB db) {
		this.db = db;
		db.getIrum();
	}
	
}

