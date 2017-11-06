package com.android.paritosh.librarymanagement;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by PARITOSH on 11/5/2017.
 */

public class BooksInfo implements Serializable {

    private String name;
    private String message;
    private String date;

    public BooksInfo() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public HashMap<String, String> toFirebaseObject() {
        HashMap<String, String> todo = new HashMap<String, String>();
        todo.put("name", name);
        todo.put("message", message);
        todo.put("date", date);

        return todo;
    }


}
