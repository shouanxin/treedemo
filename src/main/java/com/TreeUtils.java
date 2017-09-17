package com;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 树操作工具类
 */
public class TreeUtils {

    /**
     * 删除节点
     * @param tree
     * @param delLists
     * @param d
     */
    public static void deleteNode(Map<Integer,Integer> tree, List<Integer> delLists,Integer d){
        //将待删除节点放入列表中
        delLists.add(d);
        //保存待删除节点
        List<Integer> sonNodes = new ArrayList<Integer>();
        sonNodes.add(d);
        //临时保存删除节点
        List<Integer> temp = new ArrayList<Integer>();

        while(true){
            for(Integer s : sonNodes) {
                Set<Integer> keys = tree.keySet();
                Iterator<Integer> it = keys.iterator();
                while (it.hasNext()) {
                    int n = it.next();
                    if (tree.get(n) == s){
                        //待删除节点存入list
                        temp.add(n);
                        delLists.add(n);
                    }
                }
            }
            //判断是否有子节点
            if(temp.size() > 0){
                sonNodes = temp;
                temp = new CopyOnWriteArrayList<Integer>();
            }else{
                break;
            }
        }
    }
}
