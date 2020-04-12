public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int fd, int bk, Stack myStack) {
        int stepCount=0;
        for (int i=0;i<arr.length;i=i+1) {
            if (stepCount==fd) {
                for (int j=0;j<bk;j=j+1) {
                    i=(int)myStack.pop();
                }
                stepCount=0;
            }
            if (arr[i]==x)
                return i;
            myStack.push(i);
            stepCount=stepCount+1;
        }
        return -1;
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        int high=arr.length-1;
        int low=0;
        while (low<=high) {
            int mid=(low+high)/2;
            int consistency=isConsistent(arr);
            if (consistency > 0) {
                for (int i=0;i<consistency;i=i+1) {
                    high=(int)myStack.pop();
                    mid=(int)myStack.pop();
                    low=(int)myStack.pop();
                }
            }
            if (arr[mid]==x)
                return mid;
            else {
                myStack.push(low);
                myStack.push(mid);
                myStack.push(high);
                if (arr[mid] < x)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }

    private static int isConsistent(int[] arr) {
        double res = Math.random() * 100 - 75;

        if (res > 0) {
            return (int)Math.round(res / 10);
        } else {
            return 0;
        }
    }
}
