package com.aljoschability.defectr.downloader;

public interface Download {
	boolean canPause();

	int getCurrentSpeed();

	int getEstimatedSecondsLeft();
}
