import java.util.Scanner;

public class FriendsYoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Enter age of %s: ", names[i]);
            ages[i] = sc.nextInt();
            System.out.printf("Enter height (in cm) of %s: ", names[i]);
            heights[i] = sc.nextDouble();
        }

        int idxYoungest = 0;
        int idxTallest = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[idxYoungest]) idxYoungest = i;
            if (heights[i] > heights[idxTallest]) idxTallest = i;
        }

        System.out.printf("Youngest: %s (age %d)\n", names[idxYoungest], ages[idxYoungest]);
        System.out.printf("Tallest: %s (height %.2f)\n", names[idxTallest], heights[idxTallest]);

        sc.close();
    }
}
