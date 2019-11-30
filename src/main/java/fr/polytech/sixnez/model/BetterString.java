package fr.polytech.sixnez.model;

public class BetterString {
	
	private byte[] buffer;
	private int index = 0;
	
	public BetterString(int bufferLength) {
		this.buffer = new byte[bufferLength];
	}
	
	public void append(byte b) {
		if (index == buffer.length) return;
		
		buffer[index] = b;
		++index;
	}
	
	// <div class="poster">
	private static final byte[] seqFin = "<div class=\"poster\">".getBytes();
	public boolean endsWith() {
		if (20 > index) return false;
		
		for (int i = index - seqFin.length; i < index; ++i) if (buffer[i] != seqFin[i - index + seqFin.length]) return false;
		
		return true;
	}
	
	// src=...
	private static final byte[] seqDeb = "src=".getBytes();
	public boolean startsWith() {
		if (4 > index) return false;
		
		for (int i = 0; i < seqDeb.length; ++i) if (buffer[i] != seqDeb[i]) return false;
		
		return true;
	}
	
	public int length() {
		return index;
	}
	
	public void reset() {
		index = 0;
	}
	

	@Override
	public String toString() {
		return new String(buffer, 0, index);
	}
	
	public String substring(int start, int end) {
		return new String(buffer, start, end - start);
	}

}
