
package test.task.interceptor;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestLocalInterceptor extends TestSnakerBase {
	@Before
	public void before() {
		processId = engine.process().deploy(
				StreamHelper.getStreamFromClasspath("test/task/interceptor/process.snaker"));
	}
	
	@Test
	public void test() {
		Order order = engine.startInstanceById(processId, "2");
		System.out.println("order=" + order);
		List<Task> tasks = queryService.getActiveTasks(new QueryFilter().setOrderId(order.getId()));
		for(Task task : tasks) {
			engine.executeTask(task.getId(), "1");
		}
	}
}
