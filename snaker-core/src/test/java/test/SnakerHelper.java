
package test;

import javax.sql.DataSource;

import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.jdbc.JdbcHelper;
import org.snaker.engine.cfg.Configuration;

/**
 * Snaker引擎帮助类
 * @author yuqs
 * @since 1.0
 */
public class SnakerHelper {
	private static final SnakerEngine engine;
	
	static {
		DataSource dataSource = JdbcHelper.getDataSource();
		engine = new Configuration()
			.initAccessDBObject(dataSource)
			.buildSnakerEngine();
	}
	
	public static SnakerEngine getEngine() {
		return engine;
	}
}
