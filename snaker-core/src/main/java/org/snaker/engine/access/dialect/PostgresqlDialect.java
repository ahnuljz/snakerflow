
package org.snaker.engine.access.dialect;

import org.snaker.engine.access.Page;

/**
 * Postgresql数据库方言实现
 * @author yuqs
 * @since 1.3
 */
public class PostgresqlDialect implements Dialect {
	/**
	 * Postgresql分页通过limit实现
	 */
	public String getPageSql(String sql, Page<?> page) {
		StringBuffer pageSql = new StringBuffer(sql.length() + 100);
		pageSql.append(getPageBefore(sql, page));
		pageSql.append(sql);
		pageSql.append(getPageAfter(sql, page));
		return pageSql.toString();
	}

	
	public String getPageBefore(String sql, Page<?> page) {
		return "";
	}

	public String getPageAfter(String sql, Page<?> page) {
		long start = (page.getPageNo() - 1) * page.getPageSize();
		StringBuffer sb = new StringBuffer();
		sb.append(" limit ").append(page.getPageSize()).append(" offset ").append(start);
		return sb.toString();
	}
}
