
package test.concurrency;

import java.util.HashMap;
import java.util.Map;

import org.snaker.engine.SnakerEngine;
import org.snaker.engine.entity.Process;
import org.snaker.engine.test.TestSnakerBase;

/**
 * 测试并发
 * @author yuqs
 * @since 1.0
 */
public class TestConcurrent extends TestSnakerBase {
	public static void main(String[] a) {
		TestConcurrent con = new TestConcurrent();
		Process process = con.engine.process().getProcessById("simple");
		for(int i = 0; i < 50; i++) {
			new Thread(new StartProcess(con.engine, process.getId())).start();
		}
	}
}

class StartProcess implements Runnable {
	private SnakerEngine engine;
	private String processId;
	public StartProcess(SnakerEngine engine, String processId) {
		this.engine = engine;
		this.processId = processId;
	}
	
	public void run() {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("task1.operator", new String[]{"1"});
		try{
		engine.startInstanceById(processId, "2", args);//simple流程
		}catch(Exception e) {
		e.printStackTrace();	
		}
	}
	
}