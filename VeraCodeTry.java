import java.io.*;
import java.util.*;

public class VeraCodeTry{
 
	public static Class<?> loadClass(final String classname) throws ClassNotFoundException
	{
		return Thread.currentThread().getContextClassLoader().loadClass(classname);
	}
}

