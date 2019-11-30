
package org.snaker.engine.scheduling.quartz;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.core.ServiceContext;
import org.snaker.engine.entity.Process;
import org.snaker.engine.helper.AssertHelper;
import org.snaker.engine.helper.StringHelper;
import org.snaker.engine.model.NodeModel;
import org.snaker.engine.model.ProcessModel;
import org.snaker.engine.scheduling.IScheduler;

/**
 * 抽象的job类
 * @author yuqs
 * @since 1.4
 */
public abstract class AbstractJob implements Job {
	private static final Logger log = LoggerFactory.getLogger(AbstractJob.class);
	/**
	 * 调度器接口
	 */
	private IScheduler scheduler;
	/**
	 * 流程引擎
	 */
	protected SnakerEngine engine = ServiceContext.getEngine();
	
	@SuppressWarnings("unchecked")
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		if(engine == null) throw new JobExecutionException("Snaker流程引擎初始化失败.");
		Map<String, Object> data = context.getJobDetail().getJobDataMap().getWrappedMap();
		if(data == null) throw new JobExecutionException("根据job执行的上下文获取不到snaker相关信息.");
		String key = (String)data.get(IScheduler.KEY);
		String model = (String)data.get(IScheduler.MODEL);
		AssertHelper.notEmpty(key);
		data.remove(IScheduler.KEY);
		data.remove(IScheduler.MODEL);
		
		String[] ids = key.split("-");
		if(ids.length != 3) {
			log.warn("id值不合法,执行操作被忽略.");
			return;
		}
		String processId = ids[0];
		String orderId = ids[1];
		String taskId = ids[2];
		
		Process process = engine.process().getProcessById(processId);
		ProcessModel processModel = process.getModel();
		NodeModel nodeModel = null;
		if(processModel != null && StringHelper.isNotEmpty(model)) {
			nodeModel = processModel.getNode(model);
		}
		exec(process, orderId, taskId, nodeModel, data);
	}

	/**
	 * 抽象方法，由具体的job进行处理
	 * @param process 流程定义对象
	 * @param orderId 流程实例id
	 * @param taskId 任务id
	 * @param nodeModel 节点模型
	 * @param data 执行数据
	 * @throws JobExecutionException job执行异常
	 */
	abstract void exec(Process process, String orderId,
			String taskId, NodeModel nodeModel, Map<String, Object> data) throws JobExecutionException;
	
	/**
	 * 获取调度器接口
	 * @return
	 */
	protected IScheduler schedule() {
	    if(scheduler == null) {
	    	scheduler = ServiceContext.getContext().find(IScheduler.class);
	    }
	    return scheduler;
	}
}
