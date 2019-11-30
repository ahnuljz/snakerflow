
package test.query;

import org.junit.Test;
import org.snaker.engine.access.Page;
import org.snaker.engine.entity.Task;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestNativeQuery extends TestSnakerBase {
	@Test
	public void test() {
		System.out.println(engine.query().nativeQueryList(new Page<Task>(), Task.class, "select * from wf_task where task_type=?", 0));
	}
}
