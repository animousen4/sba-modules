package com.animousen4.game.engine;

import org.testcontainers.containers.PostgreSQLContainer;

import static com.animousen4.game.engine.TestContainerConstants.*;

public class GameEngineContainerSettings extends PostgreSQLContainer<GameEngineContainerSettings> {
	private static GameEngineContainerSettings container;

	private GameEngineContainerSettings() {
		super(DOCKER_IMAGE_VERSION);
	}

	public static GameEngineContainerSettings getInstance(String script) {
		if (container == null) {
			container = new GameEngineContainerSettings()
					.withInitScript(script);
		}
		return container;
	}

	@Override
	public void start() {
		super.start();
		System.setProperty(DB_URL, container.getJdbcUrl());
		System.setProperty(DB_USERNAME, container.getUsername());
		System.setProperty(DB_PASSWORD, container.getPassword());
	}

	@Override
	public void stop() {
		//do nothing, JVM handles shut down
	}
}