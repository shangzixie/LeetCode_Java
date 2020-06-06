package LeetCode_Java.Topological_Graph_BFS;

import java.util.*;

public class Course_Schedule {
                                                // [cour, pre]
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build graph:  pre course ---> cur course
        //               prerequisites[i][1] ---> prerequisites[i][0]
        HashMap<Integer, List<Integer>> graph = buildMap(numCourses, prerequisites);

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            if (inDegree.containsKey(prerequisites[i][0])) inDegree.put(prerequisites[i][0],inDegree.get(prerequisites[i][0])+1);
            else inDegree.put(prerequisites[i][0], 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoSeq = new ArrayList<>();
        for (int i =0; i < numCourses; i++){
            if (!inDegree.containsKey(i)){
                queue.add(i);
                topoSeq.add(i);
            }
        }
        while(!queue.isEmpty()){
            int course = queue.poll();
            for (int neighbor : graph.get(course)){
                inDegree.put(neighbor, inDegree.get(neighbor) -1 );
                if (inDegree.get(neighbor) == 0){
                    queue.add(neighbor);
                    topoSeq.add(neighbor);
                }
            }
        }
        return topoSeq.size() == numCourses;
    }

    private HashMap<Integer, List<Integer>> buildMap(int numCourses, int[][] prerequisites){
        // build graph:  pre course ---> cur course
        //               prerequisites[i][1] ---> prerequisites[i][0]
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
           map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return map;
    }
}
