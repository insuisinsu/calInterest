package bank;

import java.text.DecimalFormat;
import java.util.Scanner;

public class calcInterest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("보증금을 입력하세요.");
		long deposit = sc.nextLong();
		System.out.println("보유금을 입력하세요.");
		long mine = sc.nextLong();
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
			bankList[i].calcInterest(deposit, mine);
		}
		// 출력
		
		DecimalFormat df = new DecimalFormat("###,###");
		
		System.out.printf("전세금 : "+deposit +"   보유금 : "+mine);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.printf("%18s %15s %15s %15s %15s %15s", "bank |", "loan |", "loanInterest |", "creditLoan |", "creditInterest |", "TotalInterest |");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < bankList.length; i++) {
			System.out.printf("%-15s %1s %15s %15s %15s %15s %15s",
					bankList[i].name, ":",df.format(bankList[i].loan),df.format(bankList[i].loanInterest/12)
					, df.format(bankList[i].creditLoan), df.format(bankList[i].creditInterest/12),
					df.format((bankList[i].loanInterest + bankList[i].creditInterest)/12));
			System.out.println();
		}
		
	}
}
