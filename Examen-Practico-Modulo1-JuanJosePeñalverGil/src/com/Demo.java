package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import com.Estudiante.Facultades;
import com.Estudiante.Sesion;

public class Demo {
	public static void main(String[] args) {
		List<Estudiante>estudiantes;
		estudiantes=new ArrayList();
		estudiantes.addAll(Estudiante.CrearEstudiantes(50));
		
		
		/***********************
		*  1. Recorrer el listado de estudiantes y obtener un mapa que contenga el nombre y los apellidos de cada estudiante con el
		*  total de d�as que han asistido al gimnasio desde su fecha de matriculaci�n.�
		************************/
		/*/
		Map<String, Double> lJ;
		lJ=new HashMap<>();
		lJ=estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getNComplet,
		Collectors.averagingLong(Estudiante::getDiasAsistenciaGym)));
		for(Map.Entry<String, Double> entry : lJ.entrySet()) {
		String nombreC=entry.getKey();
		Double dias=entry.getValue();
		/*/
		Map<String, Long> lJ;
		lJ=new HashMap<>();
		lJ=estudiantes.stream().collect(Collectors.toMap(Estudiante::getNComplet,Estudiante::getDiasAsistenciaGym));
		for(Map.Entry<String, Long> entry : lJ.entrySet()) {
		String nombreC=entry.getKey();
		Long dias=entry.getValue();
		/**/
			
		/**/	
			System.out.println("Nombre Completo: "+nombreC+"  Dias Asistidos: "+dias);
		/**/
		}
		
			/********************************
			 * 2. Almacenar en una colecci�n�map los estudiantes agrupados por la sesi�n�(ma�ana, tarde o noche) 
			 *  a la cual asisten al gimnasio.
			 **************************** */
			Map<Estudiante.Sesion,List<Estudiante>>m;
			m=new HashMap<>();
			
for(Estudiante.Sesion s:Estudiante.Sesion.values())
	m.put(s,estudiantes.stream().filter(e->e.getSesion().equals(s)).collect(Collectors.toList()));
	for(Map.Entry<Estudiante.Sesion, List<Estudiante>> entry : m.entrySet()) {
				/**/
		System.out.println("Sesion: "+entry.getKey());
		Estudiante.pintarOrdenado(entry.getValue());
				/**/
			}
			
			
			/********************************
			 * 3. Almacenar en una Colecci�n�Map los estudiantes, agrupados por Facultad y por horario de asistencia al gimnasio
			 **************************** */
			Map<Facultades, Map<Sesion, List<Estudiante>>>mapFyS;
			mapFyS=new HashMap<>();
			
			mapFyS=estudiantes.stream()
					.collect(Collectors.groupingBy(Estudiante::getFacultad,Collectors.groupingBy(Estudiante::getSesion)));
						
			for(Map.Entry<Facultades, Map<Sesion, List<Estudiante>>> entry : mapFyS.entrySet()) {
				for(Map.Entry<Sesion, List<Estudiante>> entry2:entry.getValue().entrySet()) {
				/**/
					System.out.println("Facultad de "+entry.getKey()+" Sesion: "+entry2.getKey());
					System.out.println();
					Estudiante.pintarOrdenado(entry2.getValue());		
					System.out.println();
			  /**/
				}
		}
			
		/****************************
		 * 4. Obtener un mapa con el estudiante que practica mas horas de deporte diariamente por facultad.
		******************************/
	//Creo un mapa con las facultades y el mayor dia de asistencia al gym
	Map<Facultades, Long>mapFacultadLong;
	mapFacultadLong=new HashMap<>();
	for(Estudiante.Facultades fac:Estudiante.Facultades.values()) {
		mapFacultadLong.put(fac,estudiantes.stream().filter(a -> a.getFacultad() == fac)
				.mapToLong(Estudiante::getDiasAsistenciaGym).max().getAsLong());
}
	//Creo un mapa con las facultades y el estudiante de mayor dias de asistencia al gym
	Map<Facultades,Estudiante>mapFacultadEstudiante;
	mapFacultadEstudiante=new HashMap<>();
	for (Estudiante e:estudiantes) {
		if(e.getHorasDiaGym()==mapFacultadLong.get(e.getFacultad()))
			mapFacultadEstudiante.put(e.getFacultad(),e);
	}
	

	for(Entry entry:mapFacultadEstudiante.entrySet()) {
		System.out.println("Facultad de "+entry.getKey()+": Estudiante: "+(entry.getValue()));
	}
	mapFacultadEstudiante.forEach((fac,es)->System.out.println("Facultad de "+fac+": Estudiante: "+es.datos()));


	/****************************
	 * 5. Obtener una Coleccion que almacene, por facultad, el total de horas dedicadas a la practica del deporte
	 *  por los estudiantes que llevan mas de un a�o de existencia
	******************************/
	
	//Creo un mapa de estudiantes ordenados con las facultades y el mayor dia de asistencia al gym
		Map<Facultades, List<Estudiante>>mapFacultadEstudianteA�o;
		mapFacultadEstudianteA�o=new HashMap<>();
		mapFacultadEstudianteA�o=estudiantes.stream().filter(e->e.getDiasAsistenciaGym()>365).collect(Collectors.groupingBy(Estudiante::getFacultad));
	/*	
		Collections.sort(mapFacultadEstudianteA�o.values(),new Comparator <Estudiante>() {
		    public int compare(Estudiante o1, Estudiante o2) {
		    	return (o2.getHorasDiaGym() < o1.getHorasDiaGym()?1:0);
		    	}
		    });
		*/
		
		for(Estudiante.Facultades fac:mapFacultadEstudianteA�o.keySet()) {
			for(Estudiante es:mapFacultadEstudianteA�o.get(fac)) {
				System.out.println("Facultad de "+fac+" Estudiante: "+es.getNComplet()+" "+es.getDiasAsistenciaGym());
			}}
		

	
	
	
	
}
								
		/*aplicar para todos los anteriores
		 * 1. En todos los casos, visualizar el contenido de la colecci�n�Map resultante, utilizando la sentencia for Extendida
		 *  y los m�todos�de la clase Stream, operaciones de agregado y expresiones lambda.
		 *
		 *2. Visualizar los estudiantes ordenados por el primer apellido en orden alfab�tico�inverso y
		 * por la fecha de matriculaci�n�en el gimnasio en orden cronol�gico�inverso, es decir, que se muestren primero
		 *  los que se matricularon mas recientemente en el gimnasio.
		 * 
		 * */
		
}
