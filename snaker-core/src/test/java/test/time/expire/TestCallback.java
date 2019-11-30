
package test.time.expire;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.entity.Task;
import org.snaker.engine.scheduling.JobCallback;

/**
 * @author yuqs
 * @since 1.0
 */
public class TestCallback implements JobCallback {
	private static final Logger log = LoggerFactory.getLogger(TestCallback.class);
	public void callback(String taskId, List<Task> newTasks) {
		log.info("callback taskId=" + taskId);
		log.info("newTasks=" + newTasks);
	}
}
