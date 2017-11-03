package com.android.paritosh.librarymanagement;

/**
 * Created by PARITOSH on 10/26/2017.
 */

public class UserInformation {
    public String name;
    public String halltckt;

    public UserInformation() {

    }

    public UserInformation(String name) {
        this.name = name;
        //this.halltckt = halltckt;
    }
    public UserInformation(String name, String halltckt) {
        this.name = name;
        this.halltckt = halltckt;
    }
}
