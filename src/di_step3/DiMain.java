package di_step3;

public class DiMain {

	public DiMain(DB db) { //외부환경
		db.getIrum();
	}
	
	public static void main(String[] args) {
		Assembler ass = new Assembler(); //어떤 DB를 컨트롤해서 가져왔는 지 알 수 X.
		DB db = ass.getDb();
		DiMain dm = new DiMain(db);
	}
}



