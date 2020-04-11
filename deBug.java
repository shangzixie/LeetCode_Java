package LeetCode_Java;

import java.util.*;





public class deBug {
    class wordCount{
        int count;
        String word;
        wordCount(String word, int count){
            this.count = count;
            this.word = word;
        }
    }

    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {

        // build map to recode the number of toys
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : toys){
            map.put(s.toLowerCase(), 0);
        }


        for (String quote : quotes){
            String[] words = quote.split("\\W");
            HashSet<String> set = new HashSet<>();  //record if the word has been added
            for (String word : words){
                String wordLowCase = word.toLowerCase();
                if (!set.contains(word) && map.containsKey(word)){
                    set.add(word);
                    map.put(word, map.get(word) + 1);
                }

            }

        }
;
        ArrayList<wordCount> res = new ArrayList<>();
        PriorityQueue<wordCount> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.count, b.count));
        PriorityQueue<String> heap2 = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        ArrayList<String> res1 = new ArrayList<>();
        for (String str : map.keySet()){
            wordCount a = new wordCount(str, map.get(str));
            res.add(a);
        }
        Collections.sort(res, (a, b) -> a.count - b.count);


        return res1;
    }
}
