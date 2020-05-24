package di_step1;

public class DiMain {
	public DiMain(MsSql sql) {
		sql.getId();
	}
	public static void main(String[] args) {
		MsSql sql = new MsSql();
		new DiMain(sql);
	}

}





