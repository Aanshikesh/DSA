class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] arr = {0,31,59,90,120,151,181,212,243,273,304,334,365};

        int aA = arr[Integer.parseInt(arriveAlice.substring(0,2)) - 1]
                + Integer.parseInt(arriveAlice.substring(3,5));

        int dA = arr[Integer.parseInt(leaveAlice.substring(0,2)) - 1]
                + Integer.parseInt(leaveAlice.substring(3,5));

        int aB = arr[Integer.parseInt(arriveBob.substring(0,2)) - 1]
                + Integer.parseInt(arriveBob.substring(3,5));

        int dB = arr[Integer.parseInt(leaveBob.substring(0,2)) - 1]
                + Integer.parseInt(leaveBob.substring(3,5));

        int start = Math.max(aA, aB);
        int end   = Math.min(dA, dB);

        if (end < start) return 0;

        return end - start + 1;
    }
}
