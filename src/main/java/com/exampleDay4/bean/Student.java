package com.exampleDay4.bean;

public class Student {
int Sid;
String sname;
public int getSid() {
	return Sid;
}
public void setSid(int sid) {
	Sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public Student(int sid, String sname) {
	super();
	Sid = sid;
	this.sname = sname;
}

}
