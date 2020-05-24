package di_autowire;

public class Oracle implements DB{ //내부환경

	@Override
	public void getIrum() {
		System.out.println("choi!");
	}
}




