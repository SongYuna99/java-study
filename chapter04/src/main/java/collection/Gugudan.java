package collection;

import java.util.Objects;

public class Gugudan {
	private int lValue;
	private int rValue;

	public Gugudan(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	@Override
	public String toString() {
		return "Gugudan [lValue=" + lValue + ", rValue=" + rValue + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(lValue, rValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gugudan other = (Gugudan) obj;
		return lValue == other.lValue && rValue == other.rValue;
	}

	/**
	 * @return the lValue
	 */
	public int getlValue() {
		return lValue;
	}

	/**
	 * @param lValue the lValue to set
	 */
	public void setlValue(int lValue) {
		this.lValue = lValue;
	}

	/**
	 * @return the rValue
	 */
	public int getrValue() {
		return rValue;
	}

	/**
	 * @param rValue the rValue to set
	 */
	public void setrValue(int rValue) {
		this.rValue = rValue;
	}

}
