package prob03;

import java.util.Objects;

public class Money {
	private int amount;

	/* 코드 작성 */
	public Money(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}

	public Money add(Money inputMoney) {
		Money resultMoney = new Money(amount + inputMoney.getAmount());
		return resultMoney;
	}

	public Money minus(Money inputMoney) {
		Money resultMoney = new Money(amount - inputMoney.getAmount());
		return resultMoney;
	}

	public Money multiply(Money inputMoney) {
		Money resultMoney = new Money(amount * inputMoney.getAmount());
		return resultMoney;
	}

	public Money devide(Money inputMoney) {
		Money resultMoney = new Money(amount / inputMoney.getAmount());
		return resultMoney;
	}

	// getter - setter
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
