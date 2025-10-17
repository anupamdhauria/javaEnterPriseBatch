package in.ineuron.generator;

import java.util.UUID;

public class RandomIdGenerator {

	public static String generateId() {
		return UUID.randomUUID().toString().replace("-","").substring(0, 10);
	}
}
