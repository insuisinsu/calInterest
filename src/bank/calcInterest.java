package bank;

public class calcInterest {
	public static void main(String[] args) {
		
		Bank lh = new LH();
		Bank kakaoSalary = new KakaoSalary();
		
		Bank[] bankList = new Bank[2];
		bankList[0] = lh;
		bankList[1] = kakaoSalary;

		for(int i = 0; i < bankList.length; i++) {
			System.out.println(bankList[i].rate);
		}
		
	}
}
