
package org.snaker.engine.scheduling.quartz;

import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.snaker.engine.helper.StringHelper;
import org.snaker.engine.model.NodeModel;
import org.snaker.engine.model.TaskModel;
import org.snaker.engine.scheduling.IScheduler;
import org.snaker.engine.scheduling.JobCallback;

/**
 * 自动执行的job
 * @author yuqs
 * @since 1.4
 */
public class ExecutorJob extends AbstractJob {
	private static final Logger log = LoggerFactory.getLogger(ExecutorJob.class);
	
	/**
	 * 根据传递的执行参数，自动执行任务
	 */
	public void exec(Process process, String orderId,
			String taskId, NodeModel nodeModel, Map<String, Object> data) 
			throws JobExecutionException {
		log.info("ExecutorJob execute taskId:{}", taskId);
		if(nodeModel == null || !(nodeModel instanceof TaskModel)) {
			log.debug("节点模型为空，或不是任务模型，则不满足执行条件");
			return;
		}
		TaskModel tm = (TaskModel)nodeModel;
		List<Task> tasks = null;
		if(StringHelper.isNotEmpty(tm.getAutoExecute()) 
				&& tm.getAutoExecute().equalsIgnoreCase("Y")) {
			tasks = engine.executeTask(taskId, SnakerEngine.AUTO, data);
			schedule().delete(IScheduler.TYPE_REMINDER + taskId);
		}
		callback(tm.getCallbackObject(), taskId, tasks);
	}
	
	/**
	 * 回调类执行
	 * @param jobCallback 回调类
	 * @param taskId 任务id
	 * @param tasks 新产生的任务列表
	 */
	private void callback(JobCallback jobCallback, String taskId, List<Task> tasks) {
		if(jobCallback == null) return;
		jobCallback.callback(taskId, tasks);
	}
}
