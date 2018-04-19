package com.wangpu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kenvin on 2018/4/19.
 */

/**
 * 一个字符串J，里面是字母组成，有的字母可以代表宝石，有的只是石头；
 * 是不是宝石取决于字符串S中是否包含J中的元素。（区分大小写！区分大小写！区分大小写！）
 *
 * Example:
 *    Input: J ="Aa",S = "aAAAbbbbb"
 *    Output: 4
 */

public class FindJewels {
    public static int findJewels(String j,String s){
        int num = 0;
        for (char newS : s.toCharArray()){
            for (char newJ : j.toCharArray()){
                if (newS==newJ)
                    num++;
            }
        }
        return num;
    }

    public  static int numJewelsInStones(String J, String S) {
        int res = 0;
        Set setJ = new HashSet();
        for (char j: J.toCharArray()) setJ.add(j);
        for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
        return res;
    }

    public  static int numRexJewelsInStones(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }

    public static void main(String[] args) {
        System.out.print(findJewels("a","ZZZZaaa"));
        System.out.print(numJewelsInStones("aZ","ZZZZaaa"));
        System.out.print(numRexJewelsInStones("aZ","ZZZZaaa"));

    }
}








