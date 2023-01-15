package listas.objetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OperacionesSinAlmacenamiento {

	public static void main(String[] args) {
		
		//-----------------------------------------------------------------------
		ComponenteElectronico ventilador01 = new ComponenteElectronico(626262343
				,"Protalia","Ventilador de Pie",8600);
		ComponenteElectronico ventilador02 = new ComponenteElectronico(626262342
				,"Exo","Ventilador de Techo",18000);
		ComponenteElectronico ventilador03 = new ComponenteElectronico(626262344
				,"Exo","Ventilador de Techo/Pie Semi Industrial",22000);
		//-----------------------------------------------------------------------
		ComponenteElectronico televisor01 = new ComponenteElectronico(1231262345
				,"Samsung","Televisor 32 pulgadas Samsung",23000);
		ComponenteElectronico televisor02 = new ComponenteElectronico(1231262344
				,"Philips","Televisor Smart Led",28000);
		ComponenteElectronico televisor03 = new ComponenteElectronico(1231262343
				,"Samsung","Smart TV IDTV",32000);
		//-----------------------------------------------------------------------
		ComponenteElectronico celular01 = new ComponenteElectronico(444353566
				,"Xperia","Celular Xperia ght6",54000);
		ComponenteElectronico celular02 = new ComponenteElectronico(444353567
				,"Samsung","Celular A0872",55000);
		ComponenteElectronico celular03 = new ComponenteElectronico(444353568
				,"Motorola","Celular AAAS 78",18000);
		//-----------------------------------------------------------------------
		ComponenteElectronico tablet01 = new ComponenteElectronico(17477443
				,"Sony","Tablet Sony bjuii",14000);
		ComponenteElectronico tablet02 = new ComponenteElectronico(17477444
				,"Huawei","Tablet Huawei 221",17000);
		ComponenteElectronico tablet03 = new ComponenteElectronico(17477445
				,"Sony","Tablet Sony KSJSU8",19000);
		//-----------------------------------------------------------------------
		
		//Usaremos solo listas con streams para simplificación
		List<ComponenteElectronico> listaCompElectrs = 
				new ArrayList<>(Arrays.asList(
						ventilador01, ventilador02,ventilador03
						,televisor01,televisor02,televisor03
						,celular01,celular02,celular03
						,tablet01,tablet02,tablet03
						));
		
		
		//============== OPERACIONES CON STREAM =====================
		//--- Tipos de operaciones---
		/*
		Las operaciones principales de streams se dividen en intermedias 
		(intermediate operations) y terminales (terminal operations) según sus
		 características.

		Las operaciones intermedias se ejecutan siempre de manera lazy ,es decir, 
		que en caso de ejecutarse una operación de búsqueda que por ejemplo quisiera
		 encontrar el primer número primo de una colección, esta no debería examinar
		  todos los valores. Al ejecutarse, su resultado es un nuevo stream con el 
		  resultado de la operación aplicada. Las funciones para dicha operacion  
		  son .MAP .FILTER .SORTED .DISTINCT .PEEK .LIMIT

		Las operaciones terminales, a diferencia de las intermedias, debe pasar 
		por todos los elementos del stream para generar un resultado. Cuando se 
		ejecuta una operación de este tipo, el stream se da por concluido/cerrado
		 y no se pueden realizar más funciones de cualquier tipo (terminales o no).
		  Se considera este tipo de operaciones eager, por su característica de
		   ejecutarse antes de retornar el resultado. Las funciones para dicha 
		   operacion  son .FOREACH .COLLECT .REDUCE
		*/
		
		
		
		//NO ES NECESARIO EL USO DE STREAM PARA JAVA8, PERO SI RECOMENDABLE
		//Recomiendo para otros ejemplos..
		//https://codingfactsblog.wordpress.com/2017/08/01/jugando-con-streams-y-predicates-en-java/
		
		System.out.println("\n================================");
		System.out.println(" ======= LISTADOS COMPLETOS ========");
		System.out.println(" =================================");
		
		System.out.println("\n------- Ej Sin Stream ---------");
		listaCompElectrs.forEach(System.out::println);
		
		System.out.println("\n------- Con Stream ---------");
		listaCompElectrs.stream().forEach(System.out::println);
		
		System.out.println("\n------- Cantidad de Productos ---------");
	
		System.out.println(listaCompElectrs.stream().count());
		
		
		//LA API STREAM NOS AGILIZA LA ESPECIFICIDAD DE LO REQUERIDO A UN MENOR
		//COSTE DE PROCESAMIENTO Y CODIGO LIMPIO
		
		System.out.println("\n======================================================================");
		System.out.println(" ===== LISTADOS POR MARCAS CON FILTER (OPERADORES DE IGUALDAD )=======");
		System.out.println(" ======================================================================");

		System.out.println("\n------- PROTALIA ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca() == "Protalia")
						.forEach(System.out::println);
		
		System.out.println("\n------- SONY ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("SONY"))//El mas usado
						.forEach(System.out::println);
		
		
	
		System.out.println("\n------- HUAWEI ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("huawei"))
						.forEach(System.out::println);
		
		System.out.println("\n------- DIFERENTES A HUAWEI ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca() != ("huawei"))
						.forEach(System.out::println);
		

		System.out.println("\n================================================");
		System.out.println(" ===== LISTADOS POR CATEGORIAS DE PRODUCTOS=======");
		System.out.println(" =================================================");
		
		System.out.println("\n------- VENTILADORES ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getNombre().contains("Ventilador"))
						.forEach(System.out::println);
		
		System.out.println("\n------- CELULARES ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getNombre().contains("Cel"))
						.forEach(System.out::println);
		
		System.out.println("\n------- TELEVISORES ---------");
		listaCompElectrs.stream()
						.filter(obj->obj.getNombre().contains("Tel"))
						.forEach(System.out::println);
		
		
		
		
		
		System.out.println(" \n=============================================");
		System.out.println(" ===== LISTADOS POR MARCAS PERSONALIZADO =======");
		System.out.println(" ===============================================");
		//Podemos mostrar los campos segun lo requerido
		
		System.out.println("\n------- PHILIPS ---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" |  MARCA  |        NOMBRE       |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("Philips"))
						.forEach(obj->System.out.println(
								" | "+obj.getMarca()
								+" | "+obj.getNombre()
								+" |   "+obj.getPrecio()+"    | "
								));

		System.out.println("\n");
		
		System.out.println("\n------- SAMSUNG ---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" |  MARCA  |        NOMBRE       |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("SAMSUNG"))
						.forEach(obj->System.out.println(
								" | "+obj.getMarca()
								+" | "+obj.getNombre()
								+" |   "+obj.getPrecio()+"    | "
								));
		
		System.out.println(" \n=============================================");
		System.out.println(" ===== LISTADOS POR MARCAS PROCESADOS ==========");
		System.out.println(" ===============================================");
		
		System.out.println("\n");
		
		System.out.println("\n------- SAMSUNG (con substring)---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" | ID  |   NOMBRE   |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("SAMSUNG"))
						.forEach(obj->System.out.println(
								" | "+obj.getMarca()
								+" | "+obj.getNombre().substring(0, 10)
								+" |   "+obj.getPrecio()+"    | "
								));
		
		System.out.println("\n");
		
	
		
		System.out.println("\n------- SAMSUNG (con substring y concatenaciones)---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" |   ID   |     NOMBRE     |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("SAMSUNG"))
						.forEach(obj->System.out.println(
								" | "+obj.getId()
								+" | "+obj.getNombre().substring(0, 10).concat("...")
								+" |   $"+obj.getPrecio()+"    | "
								));
		System.out.println("\n");
		
		System.out.println("\n------- SAMSUNG (con substring y concat)---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" |   ID   |   NOMBRE   |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("SAMSUNG"))
						.forEach(obj->System.out.println(
								" | "+String.valueOf(obj.getId()).substring(0,4).concat("...")
								+" | "+obj.getNombre().substring(0, 10).concat("...")
								+" |   $"+obj.getPrecio()+"    | "
								));
		
		System.out.println("\n");
		
		System.out.println("\n------- EXO ---------");

		System.out.println(" ------------------------------------------------");
		System.out.println(" |   ID   |   NOMBRE   |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("exo"))
						.forEach(obj->System.out.println(
								" | "+String.valueOf(obj.getId()).substring(0,4).concat("...")
								+" | "+obj.getNombre().substring(0, 10).concat("...")
								+" |   $"+obj.getPrecio()+"    | "
								));
		
		System.out.println("\n");
		System.out.println("\n==========================================");
		System.out.println(" ======= LISTADOS COMPLETOS PROCESADO ========");
		System.out.println(" ===========================================");
		//Podemos mostrar los campos segun lo requerido
		
		System.out.println("\n------- LISTADO COMPLETO ---------");
		
		System.out.println(" ------------------------------------------------");
		System.out.println(" |   ID   |   NOMBRE   |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
						.forEach(obj->System.out.println(
								" | "+String.valueOf(obj.getId()).substring(0,4).concat("...")
								+" | "+obj.getNombre().substring(0, 10).concat("...")
								+" |   $"+obj.getPrecio()+"    | "
								));
		
	System.out.println("\n");
		
	System.out.println("\n------- LISTADO COMPLETO (CON LIMIT)---------");
		
		listaCompElectrs.stream()
						.limit(8)
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | NOMBRE : "+obj.getNombre()
								+" | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
		//Agregamos objetos repetidos
		listaCompElectrs.addAll(Arrays.asList(ventilador01,ventilador02,ventilador03));
		System.out.println("\n");
		
		System.out.println("\n------- LISTADO COMPLETO(objetos duplicados) ---------");
		
		System.out.println(" ------------------------------------------------");
		System.out.println(" |   ID   |   NOMBRE   |    PRECIO    |");
		System.out.println(" ------------------------------------------------");
		listaCompElectrs.stream()
		.forEach(obj->System.out.println(
				" | ID: "+obj.getId()
				+" | NOMBRE : "+obj.getNombre()
				+" | PRECIO:  $"+obj.getPrecio()+" | "
				));
		

		System.out.println("\n");
		
		System.out.println("\n------- LISTADO COMPLETO (objetos sin duplicados (distinct)) ---------");
		
		listaCompElectrs.stream()
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | NOMBRE : "+obj.getNombre()
								+" | PRECIO:  $"+obj.getPrecio()+" | "
								));
		System.out.println(" \n======================================================================");
		System.out.println("  ===== LISTADO POR MARCAS CON FILTER (OPERADORES LOGICOS) ============");
		System.out.println("  ======================================================================");
		//Podemos mostrar los campos segun lo requerido
		
		//Uso de filters con operadores relacionales y logicos
		
		System.out.println("\n------- Productos de Protalia y Exo ---------");
		
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("protalia") 
								|| obj.getMarca().equalsIgnoreCase("exo") )
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+"         | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		System.out.println("\n------- Productos de Protalia y Exo sin duplicados---------");
		
		listaCompElectrs.stream()
						.filter(obj->obj.getMarca().equalsIgnoreCase("protalia") 
								|| obj.getMarca().equalsIgnoreCase("exo") )
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca().substring(0,3).concat("...")
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
System.out.println("\n------- Productos que sean ventiladores o celulares sin duplicados---------");
		
		listaCompElectrs.stream()
						.filter(obj->obj.getNombre().contains("Cel") 
								|| obj.getNombre().contains("Vent") )
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca().substring(0,3).concat("...")
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		System.out.println(" \n======================================================================");
		System.out.println("  ===== LISTADO POR MARCAS CON FILTER (OPERADORES RELACIONALES) ============");
		System.out.println("  ======================================================================");
		
System.out.println("\n------- Productos de Samsung y Sony cuyos precios sean mayor a $10000 sin duplicados---------");
		
		listaCompElectrs.stream()
						.filter(obj->(obj.getMarca().equalsIgnoreCase("samsung")
								|| obj.getMarca().equalsIgnoreCase("sony"))
								&& obj.getPrecio() > 10000 
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
System.out.println("\n------- Productos de Samsung y Sony cuyos precios sean menores a $20000 sin duplicados---------");
		
		listaCompElectrs.stream()
						.filter(obj->(obj.getMarca().equalsIgnoreCase("samsung")
								|| obj.getMarca().equalsIgnoreCase("sony"))
								&& obj.getPrecio() < 20000 
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
System.out.println("\n------- Productos de Xperia y Huawei cuyos precios oscilen entre $12000 y $30000 sin duplicados---------");
		
		listaCompElectrs.stream()
						.filter(obj->(obj.getMarca().equalsIgnoreCase("xperia")
								|| obj.getMarca().equalsIgnoreCase("huawei"))
								&& obj.getPrecio() < 30000
								&& obj.getPrecio() > 12000
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
System.out.println("\n------- Todos los Productos que sean celulares y cuyos precios sean menores a $40000 sin duplicados---------");
		
		listaCompElectrs.stream()
						//Teniendo en consideracion el patron de productos de la lista
						.filter(obj->(obj.getNombre().startsWith("Celular"))
								&& obj.getPrecio() < 40000
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
		
System.out.println("\n------- Todos los Productos que sean celulares y cuyos precios sean mayores a $40000 sin duplicados---------");
		
		listaCompElectrs.stream()
						//Teniendo en consideracion el patron de productos de la lista
						.filter(obj->(obj.getNombre().startsWith("Celular"))
								&& obj.getPrecio() > 40000
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
		
System.out.println("\n------- Todos los Productos que sean ventiladores y televisores cuyos precios sean menores a $30000 sin duplicados---------");
		
		listaCompElectrs.stream()
						//Teniendo en consideracion el patron de productos de la lista
						.filter(obj->(obj.getNombre().startsWith("Televisor")
								|| (obj.getNombre().startsWith("Ventilador")))
								&& obj.getPrecio() < 30000
							)
						.distinct()
						.forEach(obj->System.out.println(
								" | ID: "+obj.getId()
								+" | MARCA : "+obj.getMarca()
								+" | NOMBRE : "+obj.getNombre()
								+"                     | PRECIO:  $"+obj.getPrecio()+" | "
								));
		
		
		
	}
	
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class ComponenteElectronico{
	
	//caracteristicas sucintas
	long id;
	String marca;
	String nombre;
	int precio;
}


