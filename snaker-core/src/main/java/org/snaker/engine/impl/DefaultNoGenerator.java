
package org.snaker.engine.impl;

import java.util.Random;

import org.joda.time.DateTime;
import org.snaker.engine.INoGenerator;
import org.snaker.engine.model.ProcessModel;

/**
 * 默认的流程实例编号生成器
 * 编号生成规则为:yyyyMMdd-HH:mm:ss-SSS-random
 * @author yuqs
 * @since 1.0
 */
public class DefaultNoGenerator implements INoGenerator {
	public String generate(ProcessModel model) {
		DateTime dateTime = new DateTime();
		String time = dateTime.toString("yyyyMMdd-HH:mm:ss-SSS");
		Random random = new Random();
		return time + "-" + random.nextInt(1000);
	}
}
