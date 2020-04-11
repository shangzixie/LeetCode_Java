package LeetCode_Java.Java_Basic;

import java.util.*;

public class Lambda_Sort {

    public static void main(String[] args) {
    //arraylist

        //字典序sort 一个arraylist
        ArrayList<String> al = new ArrayList<>();
        Collections.sort(al);

        //自定义
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> al1 = new ArrayList<>();

        map.put("3", 1);
        map.put("2", 2);
        map.put("1", 3);
        for(String str : map.keySet()){
            al1.add(str);
        }

        Collections.sort(al1, (a, b) -> map.get(a) - map.get(b));
        System.out.println(al1);

    //Array:
        //字典序sort
        String[] nums = new String[10];
        Arrays.sort(nums);

        //自定义
        Arrays.sort(nums, (a, b) -> map.get(a) - map.get(b));

    //heap

        //自定义
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (String str : map.keySet()){
            heap.add(str);
        }

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
        /*
        output:
            3
            2
            1
         */


    // sort 一个string

        String string = "cba";
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

    }



}
