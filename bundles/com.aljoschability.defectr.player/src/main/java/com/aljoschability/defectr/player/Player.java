package com.aljoschability.defectr.player;

public interface Player {
	public enum State {
		IDLE, PAUSED, PLAYING;
	}

	String TOPIC = "com.aljoschability.defectr/player"; //$NON-NLS-1$

	void pause();

	void play();
}
