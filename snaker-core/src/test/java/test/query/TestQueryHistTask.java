
package test.query;

import org.junit.Test;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.WorkItem;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestQueryHistTask extends TestSnakerBase {
	@Test
	public void test() {
		System.out.println(queryService.getHistoryTasks(new Page<HistoryTask>(), 
				new QueryFilter().setOperator("admin")));
		System.out.println(queryService.getHistoryWorkItems(new Page<WorkItem>(), 
				new QueryFilter().setOperator("admin")));
	}
}
