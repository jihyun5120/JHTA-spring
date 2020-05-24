package aop_anno;

public class BoardDao implements Dao{

	@Override
	public void select() {
		System.out.println("--B_select--");
	}

	@Override
	public void insert() {
		System.out.println("--B_insert--");
	}

	@Override
	public void view() {
		System.out.println("--B_view--");
	}

	@Override
	public void modify() {
		System.out.println("--B_modify--");
	}

	@Override
	public void delete() {
		System.out.println("--B_delete--");
	}
}
