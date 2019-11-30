
package test.query;

import org.junit.Test;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.WorkItem;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestQueryTask extends TestSnakerBase {
	@Test
	public void test() {
		System.out.println(queryService.getActiveTasks(new Page<Task>(), 
				new QueryFilter().setOperator("1")));
		System.out.println(queryService.getWorkItems(new Page<WorkItem>(), 
				new QueryFilter().setOperator("1").setOrderId("36c0228fcfa740d5b62682dc954eaecd")));
	}
}
