package com;
import java.util.Comparator;
import java.util.Map;
import com.Estudiante.Facultades;
public class CompararPorValor implements Comparator<Object>{
	public CompararPorValor(Map<Facultades, Integer> base) {this.base = base;}
	Map<Estudiante.Facultades,Integer>base;
	@Override
	public int compare(Object o1, Object o2){
		return base.get(o2).compareTo(base.get(o1));
		 }

}
