
package org.snaker.engine.access.transaction;

/**
 * 事务对象保持类
 * 该类用于绑定数据库访问对象（Connection、Session）
 * @author yuqs
 * @since 1.0
 */
public class TransactionObjectHolder {
	/**
	 * 线程局部容器，用于保持数据库访问对象
	 */
	private static final ThreadLocal<Object> container = new ThreadLocal<Object>();
	
	/**
	 * 绑定对象
	 * @param object
	 */
	public static void bind(Object object) {
		container.set(object);
	}
	
	/**
	 * 移除对象
	 * @return
	 */
	public static Object unbind() {
		Object object = container.get();
		container.remove();
		return object;
	}
	
	/**
	 * 返回当前对象
	 * @return
	 */
	public static Object get() {
		return container.get();
	}
	
	/**
	 * 判断是否存在事务对象
	 * @return
	 */
	public static boolean isExistingTransaction() {
		return get() != null;
	}
}
