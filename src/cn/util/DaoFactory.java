package cn.util;

public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory(){}
	
	public static DaoFactory newInstance() {
		return instance;
	}
	
	public <T> T createDao(String className, Class<T> clazz) {
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
