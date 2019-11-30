
package test.reject;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.snaker.engine.helper.StreamHelper;
import org.snaker.engine.test.TestSnakerBase;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestReject extends TestSnakerBase {
	@Before
	public void before() {
		processId = engine.process().deploy(StreamHelper
						.getStreamFromClasspath("test/reject/reject.snaker"));
		engine.startInstanceById(processId);
	}
	
	@Test
	public void test() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("number", 2);
		//engine.executeTask("f4a7a9b486ca41d3a2ebb1ecc0af75a9", null, args);
		//engine.executeAndJumpTask("737a9d4118594d69a918ed20daf347cb", null, args, "task1");
	}
}
