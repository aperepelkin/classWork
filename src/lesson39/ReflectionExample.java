package lesson39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestClass cls = new TestClass();
		setValues(cls);
		System.out.println(cls);
	}

	private static void setValues(Object cls) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = cls.getClass();
		for(Method m : clazz.getMethods()) {
			SetValue ann = m.getAnnotation(SetValue.class);
			if(ann != null) {
				m.invoke(cls, ann.value());
			}
		}
	}
}
