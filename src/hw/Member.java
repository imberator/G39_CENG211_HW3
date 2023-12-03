package hw;

public abstract class Member {

	private double discount;

	public Member() {
		this.discount = 0;
	}

	public Member(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public boolean equals(Object o) {

		if (o == null)
			return false;
		else if (getClass() != o.getClass())
			return false;
		else {
			Member otherMember = (Member) o;
			return discount == otherMember.discount;
		}
	}
	
	@Override
	public String toString() {
		return "Discount: %" + discount*100;
	}
}
