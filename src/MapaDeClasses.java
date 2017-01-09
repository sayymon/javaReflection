import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapaDeClasses{
	
	private Map<String, Class<?>> mapaDeClasses = new HashMap<String, Class<?>>();
	
	public Class<?> getClass(final String classe) throws ClassNotFoundException{
		if (mapaDeClasses.get(classe) == null){
			System.out.println("Buscando classe "+classe);
			mapaDeClasses.put(classe,Class.forName(classe));
		}
		
		return mapaDeClasses.get(classe);
	}

    private Map<String,String> mapa;

    public Class getClassExercicio(String chave) throws Exception{
        String valor = mapa.get(chave);
        if(valor != null){
            return Class.forName(valor);
        }else{
            throw new RuntimeException("Chave inválida");
        }
    }	
	
	Object getObject(String classe) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return getClass(classe).newInstance();
	}

	Object getObject(String classe, Object... params) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?>[] parameterTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; i++) {
			parameterTypes[i] = params[i].getClass();
		}
		
		return getClass(classe).getConstructor(parameterTypes ).newInstance(params);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MapaDeClasses m = new MapaDeClasses();
		System.out.println(m.getClass("java.util.ArrayList"));
		System.out.println(m.getClass("java.util.ArrayList"));
		System.out.println(m.getClass("java.util.HashSet"));
		System.out.println(m.getClass("java.util.HashSet"));
		
		List l = (List) m.getObject("java.util.ArrayList");
		System.out.println(l.getClass());
		
		Funcionario s = (Funcionario) m.getObject("Funcionario","Saymon");
		System.out.println(s.getClass());
		System.out.println(s.getNome());
	}
}
