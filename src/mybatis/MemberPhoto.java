package mybatis;

public class MemberPhoto {
	int serial;
	String mId = "";
	String rDate = "";
	String oriFile = "";
	String sysFile = "";
	
	public int getSerial() {return serial;}
	public void setSerial(int serial) {this.serial = serial;}
	public String getmId() {return mId;}
	public void setmId(String mId) {this.mId = mId;}
	public String getrDate() {return rDate;}
	public void setrDate(String rDate) {this.rDate = rDate;}
	public String getOriFile() {return oriFile;}
	public void setOriFile(String oriFile) {this.oriFile = oriFile;}
	public String getSysFile() {return sysFile;}
	public void setSysFile(String sysFile) {this.sysFile = sysFile;}
}

