
package org.snaker.engine.access.dialect;

import org.snaker.engine.access.Page;

/**
 * Mysql数据库方言实现
 * @author yuqs
 * @since 1.0
 */
public class MySqlDialect implements Dialect {
	/**
	 * mysql分页通过limit实现
	 */
	public String getPageSql(String sql, Page<?> page) {
		StringBuffer pageSql = new StringBuffer(sql.length() + 100);
		pageSql.append(sql);
		long start = (page.getPageNo() - 1) * page.getPageSize();
		pageSql.append(" limit ").append(start).append(",").append(page.getPageSize());
		return pageSql.toString();
	}
}
