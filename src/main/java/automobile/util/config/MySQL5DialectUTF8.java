package automobile.util.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @author CrazeWong
 * 自定义连接MySQL类
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {
	
	/* (non-Javadoc)
	 * @see org.hibernate.dialect.MySQL5InnoDBDialect#getTableTypeString()
	 * 使其支持UTF-8
	 */
	@Override  
    public String getTableTypeString() {  
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";    
    }
}
