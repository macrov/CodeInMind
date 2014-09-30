package com.codecompany.macrov.codeinmind.code;

/**
 * Created by 28852028 on 9/24/2014.
 */
public class Code {

    public String codeName;


    public Code(String name, CodeRecorder recorder){

        codeName = name;
        codeRecorder = recorder;



    }

    public Node getNextNode(){
        return codeRecorder.getUnMemorizedNodes().remove(0);
    }

    public boolean saveResult(Node node,String answer){
        return true;
    }

    private CodeProvider codeProvider;
    private CodeRecorder codeRecorder;

}
