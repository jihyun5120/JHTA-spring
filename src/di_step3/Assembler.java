package di_step3;
 
//[ 외부 조립기를 사용하는 이유! ]
//사용될 객체를 비지니스 로직이 있는 클래스에서 작업하지 않고, 외부의 둠으로 주요한 비지니스 로직을 보완.

public class Assembler { //외부조립기
	DB db;
	public DB getDb() { 
		return new MsSql();
	}
}





