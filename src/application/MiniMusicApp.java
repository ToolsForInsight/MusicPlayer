package application;

import javax.sound.midi.*;

public class MiniMusicApp {
	
	public static void main(String[] args) {
		
		MiniMusicApp mini = new MiniMusicApp();
		mini.play();
	}

	public void play() {
		
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			for (int i = 0; i < 4; i++) {
				
				ShortMessage lowNoteStart = new ShortMessage();
				ShortMessage medNoteStart = new ShortMessage();
				ShortMessage highNoteStart = new ShortMessage();
				ShortMessage lowNoteEnd = new ShortMessage();
				ShortMessage medNoteEnd = new ShortMessage();
				ShortMessage highNoteEnd = new ShortMessage();

				lowNoteStart.setMessage(144, 1, 44, 100);
				medNoteStart.setMessage(144, 1, 60, 100);
				
				lowNoteEnd.setMessage(128, 1, 44, 100);
				medNoteEnd.setMessage(128, 1, 60, 100);
				
				MidiEvent lowNoteOn = new MidiEvent(lowNoteStart, 1+(16*i));
				MidiEvent medNoteOn = new MidiEvent(medNoteStart, 5+(16*i));
				
				MidiEvent lowNoteOff = new MidiEvent(lowNoteEnd, 32);
				MidiEvent medNoteOff = new MidiEvent(medNoteEnd, 32);
				
				track.add(lowNoteOn);
				track.add(medNoteOn);
				track.add(lowNoteOff);
				track.add(medNoteOff);
				
				if (i % 2 != 1) {
					
					highNoteStart.setMessage(144, 1, 70, 100);
					highNoteEnd.setMessage(128, 1, 70, 100);
				}
				else {
					
					highNoteStart.setMessage(144, 1, 68, 100);
					highNoteEnd.setMessage(128, 1, 68, 100);
				}
				
				MidiEvent highNoteOn = new MidiEvent(highNoteStart, 9+(16*i));
				MidiEvent highNoteOff = new MidiEvent(highNoteEnd, 32+(16*i));
				track.add(highNoteOn);
				track.add(highNoteOff);
			}
			
			player.setSequence(seq);
			player.start();
		}
		catch (Exception ex) {
		
			ex.printStackTrace();
		}
	}
}
