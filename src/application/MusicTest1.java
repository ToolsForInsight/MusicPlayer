package application;

import javax.sound.midi.*;

public class MusicTest1 {

	public void play() {
		
		Sequencer sequencer = MidiSystem.getSequencer();
	}
	
	public static void main(String[] args) {
		
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}
}
