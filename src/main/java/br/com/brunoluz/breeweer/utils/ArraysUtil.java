package br.com.brunoluz.breeweer.utils;

import java.util.Collection;

public class ArraysUtil {

	
	/**
	 * Valida se um array é nulo ou vazio
	 * @param array
	 * @return
	 */
	public static boolean nullOuVazio(Collection<Object> array) {
		return (array == null || array.size() == 0);
	}
	
	
	public static boolean nullOuVazio(Object[] array) {
		return (array == null || array.length == 0);
	}
	
}
