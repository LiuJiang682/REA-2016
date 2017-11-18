package au.com.rea.robot.command;

import au.com.rea.robot.constants.CommonConstants.Numeral;

public enum Directions {
	EAST(0), 
	SOUTH(1), 
	WEST(2), 
	NORTH(3);
	
	private int id;
	
	Directions(final int id) {
		this.id = id;
	}

	public Directions getLeft() {
		int left = id - Numeral.ONE;
		if (left < Numeral.ZERO) {
			left = Numeral.THREE;
		}
		return getNext(left);
	}

	private Directions getNext(int nextId) {
		for (Directions d : Directions.values()) {
			if (nextId == d.id) {
				return d;
			}
		}
		throw new IllegalArgumentException("Unkown direction id: " + id);
	}
	
	public int getId() {
		return id;
	}

	public Directions getRight() {
		int right = id + Numeral.ONE;
		if (Numeral.THREE < right) {
			right = Numeral.ZERO;
		}
		
		return getNext(right);
	}
}
