package fr.polytech.sixnez.model;

import java.io.IOException;
import java.io.InputStream;

public class BetterReader {
	
	private InputStream stream;
	private int read, nextRead = -1;
	private BetterString line = new BetterString(512);
	private boolean endOfStream;
	
	public BetterReader(InputStream stream) {
		this.stream = stream;
	}
	
	public BetterString readLine() throws IOException {
		line.reset();
		
		if (nextRead != -1) {
			line.append((byte) nextRead);
			endOfStream = false;
		} else endOfStream = true;
		
		
		do {
			read = stream.read();
			if (read == -1) {
				if (endOfStream) return null;
				else return line;
			} else {
				endOfStream = false;
				
				if (read == '\r' || read == '\n') {
					while (read == '\r' || read == '\n') {
						read = stream.read();
						nextRead = read;
						
						if (read == -1) return line;
					}
					
					
					return line;
				} else {
					line.append((byte) read);
				}
			}
			
		} while (true);
	}

}
