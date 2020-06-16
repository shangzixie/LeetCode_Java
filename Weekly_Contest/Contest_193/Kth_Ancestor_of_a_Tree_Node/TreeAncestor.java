package Weekly_Contest.Contest_193.Kth_Ancestor_of_a_Tree_Node;

public class TreeAncestor {
    int[][] dp;
    int maxLevel;

    public TreeAncestor(int n, int[] parent) {
        maxLevel = (int)(Math.log(n) / Math.log(2)) + 1; // maxLevel = int (log2(n) + 1)
        dp = new int[maxLevel][n]; // dp[i][node] means the 2^i ancestor of the node (it is flipped matrix different from a normal dp)
        dp[0] = parent; //initial condition: all node's parent
        for (int level = 1; level < maxLevel; level++) {
            for (int node = 0; node < n; node++) {
                int pre = dp[level - 1][node];
                dp[level][node] = pre == -1 ? -1 : dp[level - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int power = this.maxLevel;
        while (k > 0 && node > -1) {

            if (k < 1 << power) { // 1 << power = 2^power
                power--; // let power from highest to decrease
            }else {
                node = dp[power][node]; // find the maxLevel ancestor of node
                k -= 1 << power;
            }
        }
        return node;
    }
}
