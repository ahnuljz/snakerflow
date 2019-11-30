
package test.task.right;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * 测试无权限执行任务
 * @author yuqs
 * @since 1.0
 */
public class TestNotAllow extends TestSnakerBase {
	@Before
	public void before() {
		processId = engine.process().deploy(StreamHelper
						.getStreamFromClasspath("test/task/right/process.snaker"));
	}
	
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", new String[]{"2"});
		Order order = engine.startInstanceById(processId, "2", args);
		System.out.println(order);
		List<Task> tasks = queryService.getActiveTasks(new QueryFilter().setOrderId(order.getId()));
		for(Task task : tasks) {
			engine.executeTask(task.getId(), SnakerEngine.ADMIN, args);
		}
	}
}
