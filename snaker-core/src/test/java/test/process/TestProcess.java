
package test.process;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.snaker.engine.entity.Process;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestProcess extends TestSnakerBase {
	@Test
	public void test() {
		processId = engine.process().deploy(StreamHelper.
				getStreamFromClasspath("test/task/simple/process.snaker"));
		Process process = engine.process().getProcessById(processId);
		System.out.println("output 1="+process);
		process = engine.process().getProcessByVersion(process.getName(), process.getVersion());
		System.out.println("output 2="+process);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", "1");
		engine.startInstanceById(processId, "1", args);
		engine.process().undeploy(processId);
		//engine.startInstanceById(processId, "1", args);
	}
}
