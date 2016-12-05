package org.elevenfifty.shopping;

public enum Priority {
	Itcanwait(0), Needitsoon(1), Grabitnow(2);
	private final int value;
	private Priority(int value) {
        this.value = value;
    }
	public int getValue(){
		return value;
	}
}
