package di_step2;

public class DiMain { //외부환경
	public DiMain(DB sql) {
		sql.getIrum();
	}
	public static void main(String[] args) {
		Oracle sql = new Oracle(); //사용하고자 하는 클래스만 바꾸면 됨.
		new DiMain(sql);
	}
}





