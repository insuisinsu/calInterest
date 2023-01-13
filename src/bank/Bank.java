package bank;

public class Bank {
	double rate;
	long limit;
	double ratio;
	long deposit;
	double loan;
	double mine;
	
	public double getRate() {return rate;}
	public void setRate(double rate) {this.rate = rate;}
	public long getLimit() {return limit;}
	public void setLimit(long limit) {this.limit = limit;}
	public double getRatio() {return ratio;}
	public void setRatio(double ratio) {this.ratio = ratio;}
	public long getDeposit() {return deposit;}
	public void setDeposit(long deposit) {this.deposit = deposit;}
	public double getLoan() {return loan;}
	public void setLoan(double loan) {this.loan = loan;}
	public double getMine() {return mine;}
	public void setMine(double mine) {this.mine = mine;}

	
	public Bank calcInterest() {
		return this;
	}
	
	public boolean chkDeposit() {
		
		return true;
	}
	
	public double getTotalInterest(long loan) {
		double interest = 12.34;
		
		System.out.println("123123   "+this.limit);
		
		return interest;
	}
}
class LH extends Bank {
	public LH() {
		this.rate = 0.012;
		this.limit = 100000000;
		this.ratio = 0.8;
	}
}
class KakaoSalary extends Bank {
	public KakaoSalary() {
		this.rate = 0.028;
		this.limit = 222000000;
		this.ratio = 0.8;
	}
}
class KakaoYouth extends Bank {
	public KakaoYouth() {
		this.rate = 0.028;
		this.limit = 70000000;
		this.ratio = 0.9;
	}
}