
package test.generator;

import org.snaker.engine.INoGenerator;
import org.snaker.engine.model.ProcessModel;

/**
 * @author yuqs
 * @since 1.0
 */
public class CustomNoGenerator implements INoGenerator {
	
	public String generate(ProcessModel model) {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}

}
