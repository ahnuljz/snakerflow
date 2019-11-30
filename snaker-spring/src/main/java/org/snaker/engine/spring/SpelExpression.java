
package org.snaker.engine.spring;

import java.util.Map;
import java.util.Map.Entry;

import org.snaker.engine.Expression;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spring el表达式解析器
 * @author yuqs
 * @since 1.2.2
 */
public class SpelExpression implements Expression {
	ExpressionParser parser = new SpelExpressionParser();
	
	public <T> T eval(Class<T> T, String expr, Map<String, Object> args) {
		EvaluationContext context = new StandardEvaluationContext();
		for(Entry<String, Object> entry : args.entrySet()) {
			context.setVariable(entry.getKey(), entry.getValue());
		}
		return parser.parseExpression(expr).getValue(context, T);
	}
}
