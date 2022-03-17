package com.springMVC.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookList {
	@Id
	private int BookCode;
	private String BookName;
	private String Author;
	private Date date=new Date(System.currentTimeMillis());
	
	public int getBookCode() {
		return BookCode;
	}
	public void setBookCode(int bookCode) {
		BookCode = bookCode;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "BookList [BookCode=" + BookCode + ", BookName=" + BookName + ", Author=" + Author + ", date=" + date
				+ "]";
	}
	

}