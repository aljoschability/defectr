package com.aljoschability.defectr.player;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;

public class PlayerImpl implements Player {
	@Inject
	private IEventBroker broker;

	@Override
	public void pause() {
		broker.post(Player.TOPIC, Player.State.PAUSED);
	}

	@Override
	public void play() {
		broker.post(Player.TOPIC, Player.State.PLAYING);
	}
}
