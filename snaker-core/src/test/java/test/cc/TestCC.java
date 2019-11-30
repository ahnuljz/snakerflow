
package test.cc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.entity.Order;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestCC extends TestSnakerBase {
    @Before
    public void before() {
        processId = engine.process().deploy(StreamHelper.getStreamFromClasspath("test/task/simple/process.snaker"));
    }
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", new String[]{"1"});
		Order order = engine.startInstanceByName("simple", 0, "2", args);
		engine.order().createCCOrder(order.getId(), "test");
//		engine.order().updateCCStatus("b0fcc08da45d4e88819d9c287917b525", "test");
//		engine.order().deleteCCOrder("01b960b9d5df4be7b8565b9f64bc1856", "test");
	}
}
