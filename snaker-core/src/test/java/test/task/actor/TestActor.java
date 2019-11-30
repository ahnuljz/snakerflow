
package test.task.actor;

import org.junit.Test;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestActor extends TestSnakerBase {
	@Test
	public void test() {
		//engine.task().addTaskActor("13b9edb451e5453394f7980ff4ab7ca9", new String[]{"test1", "test2"});
		engine.task().removeTaskActor("13b9edb451e5453394f7980ff4ab7ca9", "2");
	}
}
