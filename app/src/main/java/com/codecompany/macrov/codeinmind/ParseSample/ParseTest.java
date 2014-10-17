package com.codecompany.macrov.codeinmind.ParseSample;

import android.content.Context;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

/**
 * Created by 28852028 on 10/16/2014.
 */
public class ParseTest {
    Context context;
    public ParseTest(Context context){
        context = context;
        //AppIP and ClientID
        Parse.initialize(context,"ADAJl79Q7fQP5aq4WFQO1WFVZLgF001JjK0yvuSn", "AAEP8nHwnNc3XPB1XupvJASHdyXpBhyMQO34cWGJ");
    }

    //create a sample ParseObject on Parse.com
    public void createParseObject(){
        ParseObject ob = new ParseObject("TestObject");
        ob.put("Name","TestObject");
        ob.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if( e == null ){
                    Log.d("ParseTest", "Saved");
                }
            }
        });
    }


    //get a file from Parse.com
    public void getCodeXml(){
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Codes");
        query.whereEqualTo("codeName","code");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if( e == null ){
                    ParseFile xmlFile = parseObject.getParseFile("code");
                    if( xmlFile != null ){
                        xmlFile.getDataInBackground(new GetDataCallback() {
                            @Override
                            public void done(byte[] bytes, ParseException e) {
                                if( e == null ){
                                    String xml = new String(bytes);
                                    Log.d("ParseTest", xml);
                                } else {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });
    }
}
