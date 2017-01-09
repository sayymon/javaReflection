import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 */

/**
 * @author user
 *
 */
public final class ValidadorAtributosNulos {
	
	
	public static void main(String[] args) {
//		for (String string : ValidadorAtributosNulos.verificaAtributosNulos(new Funcionario("Saymon"))) {
//			System.out.println(string);
//		}

//		for (String string : ValidadorAtributosNulos.verificaAtributosString(new Funcionario())) {
//			System.out.println(string);
//		}
		Set<Entry<String,Object>> entrySet = ValidadorAtributosNulos.atributosEValorObjeto(new Funcionario("Saymon")).entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println("Atributo : " + entry.getKey() + " Valor : "+entry.getValue());
		}
	
	}	
	
	public static List<String> verificaAtributosNulos(final Object o){
		List<String> atributosNulos = new ArrayList<String>();
		
		try {
			Class<?> c = o.getClass();
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				Object valor = f.get(o);
				if (valor == null) {
					atributosNulos.add(f.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atributosNulos;
	}  
	
	public static List<String> verificaAtributosString(final Object o){
		List<String> atributosNulos = new ArrayList<String>();
		
		try {
			Class<?> c = o.getClass();
			for (Field f : c.getFields()) {
				Object valor = f.get(o);
				if (valor != null && valor instanceof String) {
					atributosNulos.add(f.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atributosNulos;
	}  
	
	
	public static List<String> buscaStringEmAtributos(Object o, String buscada){
	    try {
	        List<String> lista = new ArrayList<>();
	        Class<?> c = o.getClass();
	        for(Field f : c.getFields()){
	            Object value = f.get(o);
	            if(value != null){
	                String strValue = value.toString();
	                if(strValue.contains(buscada)){
	                    lista.add(f.getName());
	                }
	            }
	        }
	        return lista;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}	

	public static List<String> buscaValorEmAtributos(Object o, Object valor){
	    try {
	        List<String> lista = new ArrayList<>();
	        Class<?> c = o.getClass();
	        for(Field f : c.getFields()){
	            Object value = f.get(o);
	            if(value != null){
	                if(valor.equals(valor)){
	                    lista.add(f.getName());
	                }
	            }
	        }
	        return lista;
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}	
	
	public static boolean verificarSeClasseEhPaiDaOutra(Object a,Object b){
		return a.getClass().isAssignableFrom(b.getClass());
	}

	public static Map<String,Object> atributosEValorObjeto(final Object o){
		Map<String,Object> atributosEValor = new HashMap<String,Object>();
		
		try {
			Class<?> c = o.getClass();
			for (Field f : c.getDeclaredFields()) {
				f.setAccessible(true);
				Object valor = f.get(o);
				atributosEValor.put(f.getName(),valor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atributosEValor;
	}	
	
}
