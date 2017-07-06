package com.example.recyclerjsonparsing.contracts;

import com.example.recyclerjsonparsing.models.AndroidVersion;
import com.example.recyclerjsonparsing.models.JSONResponse;

import java.util.ArrayList;

/**
 * Created by Sak on 06-Jul-17.
 */

public class AndroidVersionContract {

    public interface View{

        void showAndroidVersion(ArrayList<AndroidVersion> data);
        void showError();

    }

    public interface Actions {

        void getAndroidVersions();

        void parseJSONResponse(JSONResponse jsonResponse);
    }

}
