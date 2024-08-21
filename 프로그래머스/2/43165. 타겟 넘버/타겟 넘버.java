class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
    
        return answer;
    }
    
    static void dfs(int[] arr, int depth, int target, int sum){
        if(arr.length == depth){
            if(sum == target){
                answer++;
            }
        }
        else{
            dfs(arr, depth + 1, target, sum + arr[depth]);
            dfs(arr, depth + 1, target, sum - arr[depth]);
        }
    }
}