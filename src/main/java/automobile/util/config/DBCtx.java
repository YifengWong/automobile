package automobile.util.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import automobile.util.config.PersistenceJPAConfig;

/**
 * @author CrazeWong
 * 单例模式，该上下文只需要有一个，作为数据库连接注册配置。
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
