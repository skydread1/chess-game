package tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


/**
 * @author francoise.perrin - 
 * Inspiration : http://www.jmdoudoux.fr/java/dej/chap-introspection.htm
 * 
 */
public class Introspection {

	/**
	 * private to avoid instantiation
	 */
	private Introspection() {

	}

	/**
	 * method invocation knowing its name on an object o given the right parameters
	 * 
	 * @param o - the object in which the method is acting
	 * @param args - method parameters list
	 * @param nomMethode - method name
	 * @return invoked method
	 * @throws Exception
	 */
	public static Object invoke(Object o, Object[] args, String nomMethode ) throws Exception	{
		Class<? extends Object>[] paramTypes = null;
		if(args != null){
			paramTypes = new Class<?>[args.length];
			for(int i=0;i<args.length;++i)	{
				paramTypes[i] = args[i].getClass();
			}
		}
		Method m = o.getClass().getMethod(nomMethode,paramTypes);
		return m.invoke(o,args);
	}


	/**
	 * Object creation knowing the class name
	 * Uses a no-argument constructor
	 * 
	 * @param className
	 * @return the newly created object
	 */
	public static Object newInstance(String className) {
		Object o = null;
		try	    {
			o = Class.forName (className).newInstance ();
		}
		catch (ClassNotFoundException e)	    {
			// the class does not exist
			e.printStackTrace();
		}
		catch (InstantiationException e)	    {
			// the class is abstract or an interface or without constructor accessible without parameters
			e.printStackTrace();
		}
		catch (IllegalAccessException e)	    {
			// the class is not accessible
			e.printStackTrace();
		}
		return o;
	}


	/**
	 * construction from the class name and the constructor parameters
	 * 
	 * @param className
	 * @param args - constructor arguments list
	 * @return the newly created object
	 */
	public static Object newInstance(String className, Object[] args)	 {
		Object o = null;

		try {
			// create object class
			Class<?> classe = Class.forName(className);
			// fetch the constructor corresponding to the args
			Class<?>[] paramTypes = null;
			if(args != null){
				paramTypes = new Class[args.length];
				for(int i=0;i<args.length;++i)	{
					paramTypes[i] = args[i].getClass();
				}
			}
			Constructor<?> ct = classe.getConstructor(paramTypes);
			// instantiates the new object with the constructor and the appropriate parameters
			o =  ct.newInstance (args);		
		}
		catch (ClassNotFoundException e)		{
			// the class does not exist
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)		{
			// the class does not have the constructor
			e.printStackTrace();
		}
		catch (InstantiationException e)		{
			// the class is abstract or an interface
			e.printStackTrace();
		}
		catch (IllegalAccessException e)		{
			// the class is not accessible
			e.printStackTrace();
		}
		catch (java.lang.reflect.InvocationTargetException e)		{
			// Raises exception is the invoked constructor raises an exception
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)		{
			// Wrong types of parameters 			
			e.printStackTrace();
		}
		return o;
	}



}
