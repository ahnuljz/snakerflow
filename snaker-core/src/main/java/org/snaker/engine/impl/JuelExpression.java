
package org.snaker.engine.impl;

import java.util.Map;
import java.util.Map.Entry;

import javax.el.ExpressionFactory;

import org.snaker.engine.Expression;

import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;

/**
 * Juel 表达式引擎实现
 * @author yuqs
 * @since 1.2
 */
public class JuelExpression implements Expression {
	ExpressionFactory factory = new ExpressionFactoryImpl();
	
	@SuppressWarnings("unchecked")
	public <T> T eval(Class<T> T, String expr, Map<String, Object> args) {
		SimpleContext context = new SimpleContext();
		for(Entry<String, Object> entry : args.entrySet()) {
			context.setVariable(entry.getKey(), factory.createValueExpression(entry.getValue(), Object.class));
		}
		return (T)factory.createValueExpression(context, expr, T).getValue(context);
	}
}
