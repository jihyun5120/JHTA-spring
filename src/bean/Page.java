package bean;

public class Page {
	int totListSize; //검색된 결과의 전체 건수.
	int totPage; //전체 페이지 수.
	int listSize = 10; //가변적으로 한페이지에서 보이는 데이터 수를 바꾸고 싶으면 매개변수로 받아서 사용하면 됨.
	int blockSize = 5; //페이지 선택 수가 1~5까지 나옴.
	int nowPage = 1;
	int startNo;
	int endNo;
	int startPage; //blockSize가 5이기때문에 1.
	int endPage; //5
	String findStr = ""; //""로 처리해놓으면 최소한 NullPointException은 안 나옴.
	
	public Page() {}
	public Page(int tot, int now) {
		this.totListSize = tot;
		this.nowPage = now;
		pageCompute();
	}
	
	public void pageCompute() {
		totPage = (int)Math.ceil(totListSize/(double)listSize); //ex) totListSize = 23이면, 3.
		endNo = nowPage * listSize;
		startNo = endNo - listSize + 1;
		if(endNo > totListSize) {//전체건수보다 endNo가 높아 공갈데이터가 나올 수 있는 상황을 막기 위해.
			endNo = totListSize;
		}
		endPage = (int)Math.ceil(nowPage/(double)blockSize) * blockSize; //ex) nowPage = 13이면, 15.
		startPage = endPage - blockSize + 1;
		if(endPage > totPage) { //전체페이지 수보다 endPage가 높아 공갈페이지가 나올 수 있는 상황을 막기 위해.
			endPage = totPage;
		}
	}
	
	public int getTotListSize() {
		return totListSize;
	}
	public void setTotListSize(int totListSize) {
		this.totListSize = totListSize;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public String getFindStr() {
		return findStr;
	}
	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
	
}
