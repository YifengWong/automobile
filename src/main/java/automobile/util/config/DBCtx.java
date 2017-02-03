package automobile.util.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import automobile.util.config.PersistenceJPAConfig;

/**
 * @author CrazeWong
 * ����ģʽ����������ֻ��Ҫ��һ������Ϊ���ݿ�����ע�����á�
 */
public class DBCtx {
	private static AnnotationConfigApplicationContext ctx = null;
	
	public static AnnotationConfigApplicationContext getDBCtx() {
		if (ctx == null) {
			ctx = new AnnotationConfigApplicationContext();
			ctx.register(PersistenceJPAConfig.class);
	    	ctx.refresh();
		}
		return ctx;
	}

}
