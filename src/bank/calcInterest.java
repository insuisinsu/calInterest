package bank;

import java.util.Scanner;

public class calcInterest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long deposit = sc.nextLong();
		long mine = 0;
		sc.close();
		
		Bank lh = new LH();
		Bank kakaoSalary = new KakaoSalary();
		Bank kakaoYouth = new KakaoYouth();
		
		Bank[] bankList = new Bank[3];
		bankList[0] = lh;
		bankList[1] = kakaoSalary;
		bankList[2] = kakaoYouth;
		
		// 실행
		for(int i = 0; i < bankList.length; i++) {
			bankList[i].calcInterest(deposit);
		}
		// 출력
		System.out.printf("전세금 : "+deposit +"   보유금 : "+mine);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.printf("%16s %15s %15s %15s %15s %15s", "bank", "loan", "loanInterest", "credit", "creditInterest", "TotalInterest");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < bankList.length; i++) {
			System.out.printf("%-15s %1s %15d %15d %15d %15d %15d",bankList[i].name, ":",bankList[i].loan, bankList[i].loanInterest/12
					, bankList[i].creditLoan, bankList[i].creditInterest/12, (bankList[i].loanInterest + bankList[i].creditInterest)/12);
			System.out.println();
		}
		
	}
}
