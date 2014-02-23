package norbsoft.sia01.domain.impl;

import norbsoft.sia01.domain.PerformanceException;
import norbsoft.sia01.domain.Performer;

import java.util.Properties;

/**
 * Created by jakub on 02/23/2014.
 */
public class PropertiesPerformer implements Performer {

	private Properties properties;

	@Override public void doPerform() throws PerformanceException {

		System.out.println("PropertiesPerformer");
		for (String key : properties.stringPropertyNames()) {
			System.out.println(key + ": " + properties.getProperty(key));
		}
	}

	public void setProperties(Properties properties) {

		this.properties = properties;
	}
}
