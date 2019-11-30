
package test.subprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * 测试简单的子流程
 * start->task1->subprocess1->end
 * @author yuqs
 * @since 1.0
 */
public class TestSubProcess1 extends TestSnakerBase {
	@Before
	public void before() {
		engine.process().deploy(StreamHelper
				.getStreamFromClasspath("test/subprocess/child.snaker"));
		processId = engine.process().deploy(StreamHelper
						.getStreamFromClasspath("test/subprocess/subprocess1.snaker"));
	}
	
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", new String[]{"1"});
		Order order = engine.startInstanceById(processId, "2", args);
		System.out.println("************************"+order);
		
		List<Task> tasks = engine.query().getActiveTasks(new QueryFilter().setOrderId(order.getId()));
		for(Task task : tasks) {
			System.out.println("************************begin:::::"+task);
			engine.executeTask(task.getId(), "1", args);
			System.out.println("************************end:::::"+task);
		}
	}
}
