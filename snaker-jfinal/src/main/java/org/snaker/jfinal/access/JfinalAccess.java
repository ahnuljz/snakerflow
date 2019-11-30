/* Copyright 2012-2014 the original author or authors.
package org.snaker.jfinal.access;

import java.sql.Connection;
import java.sql.SQLException;

import com.jfinal.plugin.activerecord.Config;
import org.snaker.engine.access.jdbc.JdbcAccess;

import org.snaker.jfinal.JfinalHelper;

/**
 * jfinal的数据访问实现类
 * 主要重构getConnection方法
 * 从jfinal的threadlocal中获取数据连接，事务统一由jfinal管理
 * @author yuqs
 * @since 2.0
 */
public class JfinalAccess extends JdbcAccess {
	/**
	 * 从jfinal的threadlocal中获取数据库连接
	 */
	protected Connection getConnection() throws SQLException {
        Config config = JfinalHelper.getConfig();
		Connection conn = config.getThreadLocalConnection();
		if(conn == null) {
			conn = config.getConnection();
            conn.setAutoCommit(true);
		}
		return conn;
	}
}
