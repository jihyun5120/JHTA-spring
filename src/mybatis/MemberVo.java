package mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberVo {
	String mId = "";
	String pwd = "";
	String mName = "";
	String rDate = "";
	int grade;
	List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
	
	public String getmId() {return mId;}
	public void setmId(String mId) {this.mId = mId;}
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public String getmName() {return mName;}
	public void setmName(String mName) {this.mName = mName;}
	public String getrDate() {return rDate;}
	public void setrDate(String rDate) {this.rDate = rDate;}
	public int getGrade() {return grade;}
	public void setGrade(int grade) {this.grade = grade;}
	public List<MemberPhoto> getPhotos() {return photos;}
	public void setPhotos(List<MemberPhoto> photos) {this.photos = photos;}
}