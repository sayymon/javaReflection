import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflaction {

	public static void main(String[] args) throws Throwable {
		Funcionario funcionario = new Funcionario("Saymon");
		funcionario.setRg("49883878373");
		invokarMetodosQueComecemComTest(funcionario);
	}
	
	public static void invokarMetodosQueComecemComTest(Object obj) throws Throwable{
		Class<?> clazz = obj.getClass();
		for (Method method : clazz.getMethods()) {
			if(method.getName().startsWith("test") && method.getReturnType() == void.class && method.getParameterTypes().length == 0 ){
				try {
					method.invoke(obj);
				} catch (InvocationTargetException e) {
					
					throw e.getTargetException();
				} catch (Exception e) {
					// Demais Exceções que podem ser lançadas
					e.printStackTrace();
				}
			}
		}
	}

}
