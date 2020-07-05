package Math.Permutation_Sequence;

public class Permutation_Sequence {
    int count;
    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        boolean[] visited = new boolean[n];
        count = 0;

        for (int i = 0; i < n; i++) chars[i] = (char)('0' + i + 1);
        return dfs(n, k, visited, chars, "");


    }

    private String dfs(int n, int k,boolean[] visited, char[] chars, String path) {
        if (path.length() == n) {
            count++;
            if (count == k) return path;
            return "";
        }



        for (int i = 0;i < n;i++ ) {
            if (visited[i] == true) continue;
            visited[i] = true;
            String s = dfs(n, k, visited, chars, path + chars[i]);
            if (!s.equals("")) return s;
            visited[i] = false;
        }
        return "";
    }

}
