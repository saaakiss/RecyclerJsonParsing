package com.example.recyclerjsonparsing.models;

import java.io.Serializable;

/**
 * Created by Sak on 05-Jul-17.
 */

public class AndroidVersion implements Serializable {

    private String ver;
    private String name;
    private String api;

    public String getVersion() {
        return ver;
    }

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }
}
