package automobile.util.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import automobile.util.config.PersistenceJPAConfig;

/**
 * @author CrazeWong
 * 获取上下文，其中包含持久层、服务层的bean
 * 单例模式
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
