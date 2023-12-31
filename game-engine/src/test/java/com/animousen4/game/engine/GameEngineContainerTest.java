package com.animousen4.game.engine;

import org.testcontainers.containers.PostgreSQLContainer;

public class GameEngineContainerTest extends PostgreSQLContainer<GameEngineContainerTest> {
	private static final String IMAGE_VERSION = "postgres:15.7";
	private static GameEngineContainerTest container;

	private GameEngineContainerTest() {
		super(IMAGE_VERSION);
	}

	public static GameEngineContainerTest getInstance() {
		if (container == null) {
			container = new GameEngineContainerTest();
		}
		return container;
	}

	@Override
	public void start() {
		super.start();
		System.setProperty("DB_URL", container.getJdbcUrl());
		System.setProperty("DB_USERNAME", container.getUsername());
		System.setProperty("DB_PASSWORD", container.getPassword());
	}

	@Override
	public void stop() {
		//do nothing, JVM handles shut down
	}
}