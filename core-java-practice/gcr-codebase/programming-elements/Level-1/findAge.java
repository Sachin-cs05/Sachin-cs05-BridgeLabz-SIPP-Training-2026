import java.util.*;
class findAge{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int bY = sc.nextInt();
		int cY = sc.nextInt();
		int age = cY-bY;
		System.out.println("Harry's age in "+ cY+ " is "+age);
	}
}