package bank;

public class Bank {
	String name;
	long limit;
	long deposit;
	long mine;
	double ratio;
	double loanRate;
	double creditRate = 0.08;
	long loan;
	long creditLoan;
	long loanInterest;
	long creditInterest;
	
	@Override
	public String toString() {
		return "은행:" + this.name + "  deposit:" + this.deposit + "  loan:" + this.loan + "  mine:" + this.creditLoan;
	}
	
	/**
	 * deposit 을 가지고 은행 조건에 맞추어 이자를 계산하여 Bank 에 담는다.
	 * @param deposit
	 * @return 
	 */
	public Bank calcInterest(long deposit, long mine) {
		this.setMoney(deposit, mine);
		this.splitDeposit(deposit);
		this.calcInterest();
		return this;
	}
	/**
	 * deposit(보증금) 과 mine(보유금) 을 입력받아 저장한다.
	 * @param deposit
	 * @param mine
	 */
	private void setMoney(long deposit, long mine) {
		this.deposit = deposit;
		this.mine = mine;
	}
	/**
	 * deposit 을 loan 과 mine 에 나누어 담기
	 * 단. 은행의 보증금 비율(ratio) 와 한도(limit) 를 고려함
	 * @param deposit
	 */
	private void splitDeposit(long deposit) {
		if((deposit * this.ratio) > this.limit) {
			this.loan = this.limit;
			this.creditLoan = deposit - this.limit;
		}else {
			this.loan = (long) (deposit * this.ratio);
			this.creditLoan = this.deposit - this.loan;
		}
	}
	/**
	 * 연이자 계산
	 */
	private void calcInterest() {
		this.setLoanInterest();
		this.setCreditInterest();
	}
	/**
	 * 전세대출(loan)의 연이자 계산
	 */
	private void setLoanInterest() {
		this.loanInterest = (long) (this.loan * this.loanRate);
	}
	/**
	 * 신용대출(creditLoan)의 연이자 계산
	 */
	private void setCreditInterest() {
		// creditInterest(신용대출) 에서 내가 가진 돈을 빼야한다.
		this.splitCreditInterest();
		this.creditInterest = (long) (this.creditLoan * this.creditRate);
	}
	/**
	 * creditLoan 에서 mine 을 뺀, 실제 신용대출금 계산
	 * deposit(보증금) 에서 limit(한도) 를 뺀 creditLoan(신용대출) 에서 mine(보유금)을 다시 뺀다
	 */
	private void splitCreditInterest() {
		System.out.println(this.creditLoan);
		System.out.println(this.mine);
		this.creditLoan = this.creditLoan - this.mine;
		System.out.println(this.creditLoan);
	}
}
class LH extends Bank {
	public LH() {
		this.name = "LH";
		this.loanRate = 0.012;
		this.limit = 100000000;
		this.ratio = 0.8;
	}
}
class KakaoSalary extends Bank {
	public KakaoSalary() {
		this.name = "KakaoSalary";
		this.loanRate = 0.028;
		this.limit = 222000000;
		this.ratio = 0.8;
	}
}
class KakaoYouth extends Bank {
	public KakaoYouth() {
		this.name = "KakaoYouth";
		this.loanRate = 0.028;
		this.limit = 70000000;
		this.ratio = 0.9;
	}
}