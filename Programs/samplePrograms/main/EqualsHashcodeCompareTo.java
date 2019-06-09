package main;

import java.util.Date;

public class EqualsHashcodeCompareTo implements Comparable<EqualsHashcodeCompareTo> {
	private String name;
	private int id;
	private Date dob;

	public EqualsHashcodeCompareTo(String name, int id, Date dob) {
		this.name = name;
		this.id = id;
		this.dob = dob;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null || (this.getClass() != other.getClass())) {
			return false;
		}
		EqualsHashcodeCompareTo guest = (EqualsHashcodeCompareTo) other;
		return (this.id == guest.id) && (this.name != null && name.equals(guest.name))
				&& (this.dob != null && dob.equals(guest.dob));
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = 31 * result + id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (dob != null ? dob.hashCode() : 0);
		return result;
	}

	@Override
	public int compareTo(EqualsHashcodeCompareTo o) {
		return this.id - o.id;
	}
}
