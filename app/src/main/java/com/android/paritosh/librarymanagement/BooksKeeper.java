package com.android.paritosh.librarymanagement;

/**
 * Created by PARITOSH on 12/20/2017.
 */


public class BooksKeeper {

    private String book;
    private String author;
    private int TimeStampStart,TimeStampEnd;

    public BooksKeeper() {
        //damn..i m fucked!!
    }

    public BooksKeeper(String book, String author, int TimeStamp) {
        this.book = book;
        this.author = author;
        this.TimeStampStart = TimeStampStart;
    }

    public BooksKeeper(String book, String author) {
        this.book = book;
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setbook(String book) {
        this.book = book;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public int getTimeStampStart() {
        return TimeStampStart;
    }

    public void setTimeStampStart(int TimeStampStart) {
        this.TimeStampStart = TimeStampStart;
    }

    public int getTimeStampEnd() {
        return TimeStampEnd;
    }

    public void setTimeStampEnd(int TimeStampEnd) {
        this.TimeStampEnd = TimeStampEnd;
    }
}

