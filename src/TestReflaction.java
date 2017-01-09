import java.lang.reflect.Method;

public class TestReflaction {

	public static void main(String[] args) throws Exception {
		Funcionario funcionario = new Funcionario("Saymon");
		funcionario.setRg("49883878373");
		invokarMetodosQueComecemComTest(funcionario);
	}
	
	public static void invokarMetodosQueComecemComTest(Object obj) throws Exception{
		Class<?> clazz = obj.getClass();
		for (Method method : clazz.getMethods()) {
			if(method.getName().startsWith("test") && method.getReturnType() == void.class && method.getParameterTypes().length == 0 ){
				method.invoke(obj);
			}
		}
	}

}
