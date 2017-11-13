package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		*  total de días que han asistido al gimnasio desde su fecha de matriculación. 
		************************/
		
		/**/
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
			
		/*/	
			System.out.println("Nombre Completo: "+nombreC+"  Dias Asistidos: "+dias);
		/**/
		}
		
			/********************************
			 * 2. Almacenar en una colección map los estudiantes agrupados por la sesión (mañana, tarde o noche) 
			 *  a la cual asisten al gimnasio.
			 **************************** */
			Map<Estudiante.Sesion,List<Estudiante>>m;
			m=new HashMap<>();
			
for(Estudiante.Sesion s:Estudiante.Sesion.values())
	m.put(s,estudiantes.stream().filter(e->e.getSesion().equals(s)).collect(Collectors.toList()));
	for(Map.Entry<Estudiante.Sesion, List<Estudiante>> entry : m.entrySet()) {
				/*/
		System.out.println("Sesion: "+entry.getKey());
		Estudiante.pintarOrdenado(entry.getValue());
				/**/
			}
			
			
			/********************************
			 * 3. Almacenar en una Colección Map los estudiantes, agrupados por Facultad y por horario de asistencia al gimnasio
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
	Map<Facultades,Estudiante>mapFyE;
	mapFyE=new HashMap<>();
	
	Map<Facultades, Double>mapFyD;
	mapFyD=new HashMap<>();
	/*
	mapFyD=estudiantes.stream().collect(Collectors.groupingBy(Estudiante::getFacultad,
			
			);
	*/
	/*
	mapFyE=estudiantes.stream()
			.collect(Collectors.groupingBy(Estudiante::getFacultad,
				Collectors.maxBy(Estudiante::getHorasDiaGym))
					
					);
*/

}
								
		/*aplicar para todos los anteriores
		 * 1. En todos los casos, visualizar el contenido de la colección Map resultante, utilizando la sentencia for Extendida
		 *  y los métodos de la clase Stream, operaciones de agregado y expresiones lambda.
		 *
		 *2. Visualizar los estudiantes ordenados por el primer apellido en orden alfabético inverso y
		 * por la fecha de matriculación en el gimnasio en orden cronológico inverso, es decir, que se muestren primero
		 *  los que se matricularon mas recientemente en el gimnasio.
		 * 
		 * */
		
}
