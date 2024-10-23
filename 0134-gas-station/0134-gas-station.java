class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startStation = 0;

        for(int i =0; i< gas.length; i++){
            totalTank += gas[i]- cost[i];
            currTank += gas[i]- cost[i];

            if(currTank<0){
                startStation = i+1;
                currTank = 0;
            }
        }
        return totalTank >= 0? startStation : -1;
    }
}