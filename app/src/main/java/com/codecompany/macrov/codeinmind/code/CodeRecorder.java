package com.codecompany.macrov.codeinmind.code;

import java.util.List;

/**
 * Created by 28852028 on 9/24/2014.
 */
public class CodeRecorder {

        //public
        public CodeRecorder(String name){

        }

        public List<Node> getMemorizedNodes(){
            return memorizedNodes;
        }

        public List<Node> getNeedReMemorizedNodes(){
            return needReMemorizedNodes;
        }

        public List<Node> getUnMemorizedNodes(){
            return null;
        }

        public boolean memorizeNode(Node node, boolean result){
//            if(result){
//                if(!memorizedNodes.contains(node)){
//                   memorizedNodes.add(node);
//                    if(needReMemorizedNodes.contains(node)){
//                        needReMemorizedNodes.remove(node);
//                    }
//                    if(unMemorizedNodes.contains(node)){
//                        unMemorizedNodes.remove(node);
//                    }
//                }
//                return true;
//            } else {
//                if(unMemorizedNodes.contains(node)){
//                    needReMemorizedNodes.add(node);
//                    unMemorizedNodes.remove(node);
//                }
//                if(needReMemorizedNodes.contains(node)){
//                    continue;
//                }
//                return true;
//            }
//            return false;
            return true;
        }
        //private
        private List<Node> memorizedNodes;
        private List<Node> needReMemorizedNodes;
        private List<Node> unMemorizedNodes;
        //save result

}
