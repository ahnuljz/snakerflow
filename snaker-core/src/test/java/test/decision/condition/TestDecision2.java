
package test.decision.condition;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.entity.Order;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * 测试决策分支流程2：使用transition的expr属性决定后置路线
 * @author yuqs
 * @since 1.0
 */
public class TestDecision2 extends TestSnakerBase {
	@Before
	public void before() {
		processId = engine.process().deploy(StreamHelper
						.getStreamFromClasspath("test/decision/condition/process.snaker"));
	}
	
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", new String[]{"1"});
		args.put("task2.operator", new String[]{"1"});
		args.put("task3.operator", new String[]{"1"});
		args.put("content", 250);
		Order order = engine.startInstanceById(processId, "2", args);
		System.out.println(order);
	}
}
