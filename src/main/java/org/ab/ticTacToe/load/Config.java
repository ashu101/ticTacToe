package org.ab.ticTacToe.load;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.ab.ticTacToe.constants.Constants;

public enum Config {
	DIMENSION(""), PLAYER1(""), PLAYER2(""), COMPUTER("");

	private String value;
	private static final String CONFIGURATION_FILE = Constants.CONFIG_FILE;

	private Config(String aValue) {
		value = aValue;
	}

	private void setValue(String aValue) {
		value = aValue;
	}

	public String getValue() {
		return value;
	}

	static {
		for (final Config c : values())
			c.setValue(load().getProperty(c.name()));
	}

	private static Properties load() {
		Properties properties = new Properties();
		try (InputStream inputStream = Config.class.getResourceAsStream(CONFIGURATION_FILE)) {
			properties.load(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(Constants.UNABLE_TO_READ_CONFIG + CONFIGURATION_FILE, e);
		}
		return properties;
	}
}
