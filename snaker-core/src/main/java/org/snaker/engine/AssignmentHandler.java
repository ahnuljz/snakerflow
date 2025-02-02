
package org.snaker.engine;

import org.snaker.engine.core.Execution;

/**
 * 分配参与者的处理接口
 * 建议使用Assignment接口
 * @author yuqs
 * @since 1.2.1
 * @see org.snaker.engine.Assignment
 */
public interface AssignmentHandler {
	/**
	 * 分配参与者方法，可获取到当前的执行对象
	 * @param execution 执行对象
	 * @return Object 参与者对象
	 */
	Object assign(Execution execution);
}
