
package org.snaker.engine.access.dialect;

import org.snaker.engine.access.Page;

/**
 * 数据库差异的方言接口
 * @author yuqs
 * @since 1.0
 */
public interface Dialect {
	/**
	 * 根据分页对象获取分页sql语句
	 * @param sql 未分页sql语句
	 * @param page 分页对象
	 * @return
	 */
	String getPageSql(String sql, Page<?> page);
}
