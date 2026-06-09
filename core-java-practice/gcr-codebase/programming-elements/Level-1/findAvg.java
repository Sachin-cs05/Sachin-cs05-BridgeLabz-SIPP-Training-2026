import java.util.*;
class findAvg{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		int C = sc.nextInt();
		int M = sc.nextInt();
		int avg = (P+C+M)/3;
		System.out.println("Sam's average mark in PCM is "+avg);
	}
}