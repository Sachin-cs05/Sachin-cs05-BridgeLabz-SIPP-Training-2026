import java.util.Arrays;

public class EmployeeAttendanceRanking {

    public static int[] topKEmployees(int[] employeeIds, int[] attendance, int k) {
        int n = employeeIds.length;
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = employeeIds[i];
            data[i][1] = attendance[i];
        }

        for (int i = 0; i < n - 1; i++) {
            int bestIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (data[j][1] > data[bestIndex][1]) {
                    bestIndex = j;
                } else if (data[j][1] == data[bestIndex][1] && data[j][0] < data[bestIndex][0]) {
                    bestIndex = j;
                }
            }

            int tempId = data[i][0];
            int tempAttendance = data[i][1];

            data[i][0] = data[bestIndex][0];
            data[i][1] = data[bestIndex][1];

            data[bestIndex][0] = tempId;
            data[bestIndex][1] = tempAttendance;
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = data[i][0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] employeeIds = {101, 102, 103, 104, 105};
        int[] attendance = {92, 85, 98, 92, 80};
        int k = 3;

        int[] result = topKEmployees(employeeIds, attendance, k);
        System.out.println("Top " + k + " Employees: " + Arrays.toString(result));
    }
}