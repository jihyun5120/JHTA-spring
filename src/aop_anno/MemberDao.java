package aop_anno;

public class MemberDao implements Dao{

	@Override
	public void select() {
		System.out.println("--M_select--");
	}

	@Override
	public void insert() {
		System.out.println("--M_insert--");
	}

	@Override
	public void view() {
		System.out.println("--M_view--");
	}

	@Override
	public void modify() {
		System.out.println("--M_modify--");
	}

	@Override
	public void delete() {
		System.out.println("--M_delete--");
	}

}
