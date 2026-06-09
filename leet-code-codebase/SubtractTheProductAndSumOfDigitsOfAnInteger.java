class SubtractTheProductAndSumOfDigitsOfAnInteger{
	public static void main(String[] args){
		int n = 234;
		System.out.println(solve(n));
	}
	public static int solve(int n) {
        int sum = 0;
        int pro = 1;
        while(n > 0){
            sum += n%10;
            pro*=n%10;
            n/=10;
        }
        return pro-sum;
    }
}