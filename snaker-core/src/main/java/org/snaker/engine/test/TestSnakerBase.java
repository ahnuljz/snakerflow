
package org.snaker.engine.test;

import org.snaker.engine.IProcessService;
import org.snaker.engine.IQueryService;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.cfg.Configuration;

/**
 * 测试辅助基类，提供execute的递归方法及SnakerEngine实例
 * @author yuqs
 * @since 1.0
 */
public class TestSnakerBase {
	protected String processId;
	protected SnakerEngine engine = getEngine();
	protected IProcessService processService = engine.process();
	protected IQueryService queryService = engine.query();
	protected SnakerEngine getEngine() {
		return new Configuration().buildSnakerEngine();
	}
}
