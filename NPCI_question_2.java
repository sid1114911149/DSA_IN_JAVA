
public class NPCI_question_2 {

    public static int minCost(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];

        // precompute max
        for(int i=0;i<n;i++){
            max[i][i] = arr[i];
            for(int j=i+1;j<n;j++){
                max[i][j] = Math.max(max[i][j-1], arr[j]);
            }
        }

        for(int len=2; len<=n; len++){

            for(int l=0; l+len-1<n; l++){

                int r = l+len-1;
                dp[l][r] = Integer.MAX_VALUE;

                for(int k=l; k<r; k++){

                    int cost = dp[l][k] +
                               dp[k+1][r] +
                               Math.abs(max[l][k] - max[k+1][r]);

                    dp[l][r] = Math.min(dp[l][r], cost);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args){

        int[] arr = {5,3,2,4,9,7};
        System.out.println(minCost(arr));
    }
}