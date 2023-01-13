package bank;

public class Bank {
	String name;
	long limit;
	long deposit;
	double ratio;
	double loanRate;
	double creditRate = 8.0;
	long loan;
	long creditLoan;
	long loanInterest;
	long creditInterest;
//	double creditLoan;
	
	
	
//	public double getRatio() {return ratio;}
//	public void setRatio(double ratio) {this.ratio = ratio;}
//	public long getLimit() {return limit;}
//	public void setLimit(long limit) {this.limit = limit;}
//	public double getLoanRate() {return loanRate;}
//	public void setLoanRate(double loanRate) {this.loanRate = loanRate;}
//	public double getCreditRate() {return creditRate;}
//	public void setCreditRate(double creditRate) {this.creditRate = creditRate;}
//	public long getDeposit() {return deposit;}
//	public void setDeposit(long deposit) {this.deposit = deposit;}
//	public double getLoan() {return loan;}
//	public void setLoan(double loan) {this.loan = loan;}
//	public double getMine() {return mine;}
//	public void setMine(double mine) {this.mine = mine;}
//	public double getCreditLoan() {return creditLoan;}
//	public void setCreditLoan(double creditLoan) {this.creditLoan = creditLoan;}
	
	@Override
	public String toString() {
		return "은행:" + this.name + "  deposit:" + this.deposit + "  loan:" + this.loan + "  mine:" + this.creditLoan;
	}
	
	/**
	 * deposit 을 가지고 은행 조건에 맞추어 이자를 계산하여 Bank 에 담는다.
	 * @param deposit
	 * @return 
	 */
	public Bank calcInterest(long deposit) {
		this.deposit = deposit;
		this.splitDeposit(deposit);
		this.calcInterest();
		return this;
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
		this.setcMineInterest();
	}
	/**
	 * 전세대출(loan)의 연이자 계산
	 */
	private void setLoanInterest() {
		this.loanInterest = (long) (this.loan * this.loanRate);
	}
	/**
	 * 신용대출(mine)의 연이자 계산
	 */
	private void setcMineInterest() {
		this.creditInterest = (long) (this.creditLoan * this.creditRate);
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