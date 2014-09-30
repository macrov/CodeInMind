package com.codecompany.macrov.codeinmind.code;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.codecompany.macrov.codeinmind.R;
/**
 * Created by 28852028 on 9/24/2014.
 */
public class CodeProvider {

    String codeName;
    boolean initialized = false;
    Context context;
    //
    public CodeProvider(Context context, String name){
        this.context = context;
        this.codeName = name;
        isCodeLocaled();

    }

    public Node getNode(int nodeID){
        return null;
    }

    public boolean isCodeLocaled(){
        if(initialized){
            return bCodeLocaled;
        } else {
            //estimate if file localed;
            boolean sdCardExist = Environment.getExternalStorageDirectory().equals(
                    Environment.MEDIA_MOUNTED);
            if(sdCardExist){
                String codePath = context.getExternalFilesDir(null).getPath() + "/codes";
                File codeFD = new File(codePath);
                if(codeFD.exists()){
                    this.bCodeLocaled = true;
                    this.initialized = true;
                    return true;
                } else {
                    this.bCodeLocaled =false;
                    this.initialized = true;
                    return false;
                }
            }
        }
        return true;
    }

    public void testResXML(){
        XmlResourceParser xrp = context.getResources().getXml(R.xml.code);
        try{
            while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){
                switch(xrp.getEventType()){
                    case XmlResourceParser.START_DOCUMENT:
                        Log.i("CodeInMind","START_DOCUMENT");
                        break;
                    case XmlResourceParser.START_TAG:
                        Log.i("CodeInMind","START_TAG :" + xrp.getName());
                        break;
                    case XmlResourceParser.TEXT:
                        Log.i("CodeInMind","TEXT :" + xrp.getText());
                    case XmlResourceParser.END_TAG:
                        Log.i("CodeInMind","END_TAG");
                        break;
                    case XmlResourceParser.END_DOCUMENT:
                        Log.i("CodeInMind","END_DOCUMENT");
                        break;
                    default:
                        break;
                }

                xrp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean bCodeLocaled;


}
