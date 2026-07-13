public class ServerCpuSpikeDetection {

    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {

            windowSum += cpuLoad[end];

            if (end >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] cpuLoad = {10, 20, 30, 40, 50, 15, 25, 35};
        int k = 5;

        int maxLoad = maxSubarrayOfSizeK(cpuLoad, k);

        System.out.println("Maximum CPU load in any " + k + "-second window: " + maxLoad);
    }
}