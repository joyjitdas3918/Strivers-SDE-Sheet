import java.util.Arrays;
public class Main {
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a,b)->a[1]-b[1]);

        int maxMeetings = 0;
        int lastEndTime = -1; 
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] > lastEndTime) {
                maxMeetings++;
                lastEndTime = meetings[i][1];
            }
        }

        return maxMeetings;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        System.out.println(obj.maxMeetings(start, end)); // Output: 4
    }
}
