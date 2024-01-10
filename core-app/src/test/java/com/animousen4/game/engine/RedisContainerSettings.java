package com.animousen4.game.engine;

import com.redis.testcontainers.RedisContainer;
import org.testcontainers.utility.DockerImageName;

import static com.animousen4.game.engine.TestContainerConstants.*;

public class RedisContainerSettings extends RedisContainer {
	private static RedisContainerSettings container;

	private RedisContainerSettings() {
		super(
				DockerImageName.parse(DOCKER_REDIS_IMAGE_VERSION)
		);
	}

	public static RedisContainerSettings getInstance() {
		if (container == null) {
			container = new RedisContainerSettings();
			container.withExposedPorts(REDIS_TEST_PORT);
		}
		return container;
	}

	@Override
	public void start() {
		super.start();
		System.setProperty("spring.redis.host", container.getHost());
		System.setProperty("spring.redis.port", container.getMappedPort(REDIS_TEST_PORT).toString());
	}

	@Override
	public void stop() {
		//do nothing, JVM handles shut down
	}
}