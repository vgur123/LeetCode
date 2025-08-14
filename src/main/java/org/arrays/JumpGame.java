package org.arrays;

public class JumpGame {

    int [] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

    public int retVal(){
        int n = nums.length;
        int jumps = 0;
        int currentPosition = 0;

        int maxReachability = 0;
        int maxReachabilityIndex = 0;

        for(int i=0; i<n; i++) {
            // Make one final leap to the end if possible!
            if(currentPosition + nums[currentPosition] >= n-1)
                return jumps + 1;
            // If we have come too ahead
            // (i.e. considered all possible jump options),
            // we need to make a jump based on greedy strategy!
            if(i > currentPosition + nums[currentPosition]) {
                currentPosition = maxReachabilityIndex;
                jumps++;
            }
            // Evaluating which jump to make next
            // by keep tracking of i + nums[i] for each position reachable
            // from the current position
            int reachability = i + nums[i];
            if(reachability > maxReachability) {
                maxReachability = reachability;
                maxReachabilityIndex = i;
            }
        }
        return jumps+1;

    }

    public static void main(String [] argc){
        JumpGame jc = new JumpGame();
        System.out.println(jc.retVal());
    }
}
