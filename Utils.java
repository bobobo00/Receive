package chat;

import java.io.Closeable;

/**
 * ������
 * @author dell
 *
 */

public class Utils {
	public static void close(Closeable... targets) {
		for(Closeable target:targets) {
			try {
				if(null!=target) {
					target.close();
				}
			}catch(Exception e) {
				
			}
		}
	}

}
