
package org.snaker.engine.access.dialect;

import org.snaker.engine.access.Page;

/**
 * Oracle数据库方言实现
 * @author yuqs
 * @since 1.0
 */
public class OracleDialect implements Dialect {
	/**
	 * oracle分页通过rownum实现
	 */
	public String getPageSql(String sql, Page<?> page) {
		StringBuffer pageSql = new StringBuffer(sql.length() + 100);
		pageSql.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pageSql.append(sql);
		long start = (page.getPageNo() - 1) * page.getPageSize() + 1;
		pageSql.append(" ) row_ where rownum < ");
		pageSql.append(start + page.getPageSize());
		pageSql.append(" ) where rownum_ >= ");
		pageSql.append(start);
		return pageSql.toString();
	}
}
