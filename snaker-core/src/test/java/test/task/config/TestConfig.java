
package test.task.config;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.entity.Order;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestConfig extends TestSnakerBase {
	@Before
	public void before() {
		processId = engine.process().deploy(StreamHelper.getStreamFromClasspath("test/task/config/process.snaker"));
	}
	
	@Test
	public void test() {
		Order order = engine.startInstanceByName("config", 0, "2", null);
		System.out.println("order=" + order);
	}
}
