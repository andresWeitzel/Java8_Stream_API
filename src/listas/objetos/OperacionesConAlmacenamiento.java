package listas.objetos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OperacionesConAlmacenamiento {
	
	public static void main(String[] args) {


		ComponenteElectronico02 ventilador01 = new ComponenteElectronico02(626262343
				,"Protalia","Ventilador de Pie",8600);
		ComponenteElectronico02 ventilador02 = new ComponenteElectronico02(626262342
				,"Exo","Ventilador de Techo",18000);
		ComponenteElectronico02 ventilador03 = new ComponenteElectronico02(626262344
				,"Exo","Ventilador de Techo/Pie Semi Industrial",22000);
		//-----------------------------------------------------------------------
		ComponenteElectronico02 televisor01 = new ComponenteElectronico02(1231262345
				,"Samsung","Televisor 32 pulgadas Samsung",23000);
		ComponenteElectronico02 televisor02 = new ComponenteElectronico02(1231262344
				,"Philips","Televisor Smart Led",28000);
		ComponenteElectronico02 televisor03 = new ComponenteElectronico02(1231262343
				,"Samsung","Smart TV IDTV",32000);
		//-----------------------------------------------------------------------
		ComponenteElectronico02 celular01 = new ComponenteElectronico02(444353566
				,"Xperia","Celular Xperia ght6",54000);
		ComponenteElectronico02 celular02 = new ComponenteElectronico02(444353567
				,"Samsung","Celular A0872",55000);
		ComponenteElectronico02 celular03 = new ComponenteElectronico02(444353568
				,"Motorola","Celular AAAS 78",18000);
		//-----------------------------------------------------------------------
		ComponenteElectronico02 tablet01 = new ComponenteElectronico02(17477443
				,"Sony","Tablet Sony bjuii",14000);
		ComponenteElectronico02 tablet02 = new ComponenteElectronico02(17477444
				,"Huawei","Tablet Huawei 221",17000);
		ComponenteElectronico02 tablet03 = new ComponenteElectronico02(17477445
				,"Sony","Tablet Sony KSJSU8",19000);
		//-----------------------------------------------------------------------
		
		//Usaremos solo listas con streams para simplificación
		List<ComponenteElectronico02> listaCompElectrs = 
				new ArrayList<>(Arrays.asList(
						ventilador01, ventilador02,ventilador03
						,televisor01,televisor02,televisor03
						,celular01,celular02,celular03
						,tablet01,tablet02,tablet03
						));
		
		/*La operaciones con stream por lo general debemos almacenar el valor de
		 * dicha opercion para posteriormente hacer uso de ella, como por ejemplo
		 * sacar un maximo de precios, obtener ciertos elementos de utilidad y 
		 * almacenarlos en listas, etc.
		 * 
		 * El procedimiento es practicamente el mismo, la diferencia es que si 
		 * almacenamos los elementos procesados en listas, tendremos que trabajar 
		 * con un Collector, ya que el stream es un flujo de datos, no una lista
		 * por ende tendremos que realizar la primera conversion de lista a stream 
		 * y el resultado de n operaciones convertirla a una lista nuevamente
		*/
		
		
		System.out.println("\n================================");
		System.out.println(" ======= LISTADO COMPLETO  ========");
		System.out.println(" =================================");
		
		System.out.println("\n------- Sin almacenamiento ---------");
		listaCompElectrs.stream().forEach(System.out::println);
		
		System.out.println("\n------- Con almacenamiento ---------");
		
		List<ComponenteElectronico02> listaConvertida = listaCompElectrs.stream().collect(Collectors.toList());
		
		listaConvertida.forEach(System.out::println);
		
		System.out.println("\n------- Cantidad de Productos ---------");
		
		int cantProductos = (int) listaConvertida.stream().count();
		
		System.out.println(cantProductos);
		
		
		System.out.println("\n=============================================");
		System.out.println(" =========== LISTADOS POR CATEGORIA ===========");
		System.out.println(" ==============================================");
		
		System.out.println("\n------- Listado de Celulares ---------");
		
		List<ComponenteElectronico02> listadoCelulares = 
				listaCompElectrs
				.stream()
				.filter(obj->obj.getNombre().startsWith("Celular") 
						|| obj.getNombre().contains("Cel")
						|| obj.getNombre().contains("Celular"))
				.collect(Collectors.toList());
		
		listadoCelulares.forEach(System.out::println);
		
		
		
		System.out.println("\n------- Listado de Televisores ---------");
		
		List<ComponenteElectronico02> listadoTelevisores = 
				listaCompElectrs
				.stream()
				.filter(obj->obj.getNombre().startsWith("Televisor")
						|| obj.getNombre().contains("TV")
						|| obj.getNombre().contains("Televisor"))
				.collect(Collectors.toList());
		
		listadoTelevisores.forEach(System.out::println);
		
		
		System.out.println("\n------- Listado de Ventiladores ---------");

		List<ComponenteElectronico02> listadoVentiladores = 
				listaCompElectrs
				.stream()
				.filter(obj->obj.getNombre().startsWith("Ventilador")
						|| obj.getNombre().contains("Vent")
						|| obj.getNombre().contains("Ventilador"))
				.collect(Collectors.toList());
		
		listadoVentiladores.forEach(System.out::println);
		

		System.out.println("\n========================================================");
		System.out.println(" ======= PRODUCTOS CON PRECIOS MAX/MIN POR CATEGORIA========");
		System.out.println(" =========================================================");
		
		
		//Desde mi punto de vista, es completamente logico que referenciando listas
		//podemos escalar el nivel de procesamiento, tanto en archivos, memoria o base
		//de datos
		
		
		//https://www.techiedelight.com/es/find-maximum-minimum-custom-objects-java/
		//https://www.geeksforgeeks.org/stream-max-method-java-examples/
		
		
		System.out.println("\n------- Celular con el precio maximo (Comparator) ---------");

		
		//Reutilizamos el listado de celulares para obtener el objeto con el precio maximo
		//Acotamos cantidad de codigo final
		ComponenteElectronico02 precioMaxListCel = 
				listadoCelulares
				.stream()
				.max(Comparator.comparingInt(ComponenteElectronico02::getPrecio))
				.get();
		
		System.out.println(precioMaxListCel);
		
		
		System.out.println("\n------- Celular con el precio maximo (Lambdas) ---------");
	
		ComponenteElectronico02 precioMaxListCel02 = 
				listadoCelulares
				.stream()
				.max((x, y) -> x.getPrecio() - y.getPrecio())
				//.max((x, y) -> Integer.compare(x.getPrecio(), y.getPrecio()))
				.get();
		
		System.out.println(precioMaxListCel02);
		
		System.out.println("\n------- Celular con el precio minimo (Comparator) ---------");

		ComponenteElectronico02 precioMinListCel = 
				listadoCelulares
				.stream()
				.min((x, y) -> x.getPrecio() - y.getPrecio())
				//.max((x, y) -> Integer.compare(x.getPrecio(), y.getPrecio()))
				.get();
		
		System.out.println(precioMinListCel);
		
		System.out.println("\n------- Televisor con el precio maximo (Comparator) ---------");

		ComponenteElectronico02 precioMaxListTel = 
				listadoTelevisores
				.stream()
				.max((x, y) -> x.getPrecio() - y.getPrecio())
				.get();
		
		System.out.println(precioMaxListTel);
		
		
		System.out.println("\n------- Televisor con el precio minimo (Lambdas) ---------");

		ComponenteElectronico02 precioMinListTel = 
				listadoTelevisores
				.stream()
				.min((x, y) -> x.getPrecio() - y.getPrecio())
				.get();
		
		System.out.println(precioMinListTel);
		
		
		System.out.println("\n------- Ventilador con el precio maximo (Lambdas) ---------");

		ComponenteElectronico02 precioMaxListVent = 
				listadoVentiladores
				.stream()
				.max((x, y) -> x.getPrecio() - y.getPrecio())
				.get();
		
		System.out.println(precioMaxListVent);
		
	
		System.out.println("\n------- Ventilador con el precio minimo (Lambdas) ---------");

		ComponenteElectronico02 precioMinListVent = 
				listadoVentiladores
				.stream()
				.min((x, y) -> x.getPrecio() - y.getPrecio())
				.get();
		
		System.out.println(precioMinListVent);
		
	
		System.out.println("\n========================================================");
		System.out.println(" ======= LISTADO DE PRODUCTOS CON PRECIOS MAX/MIN ========");
		System.out.println(" =========================================================");
		
		
		
		System.out.println("\n------- Listado con los precios minimos de los productos ---------");

		List<ComponenteElectronico02> listadoPreciosMin =
					Arrays.asList(precioMinListCel,precioMinListTel,precioMinListVent);
		
		listadoPreciosMin.forEach(System.out::println);
		
		
		System.out.println("\n------- Listado con los precios maximos de los productos ---------");

		List<ComponenteElectronico02> listadoPreciosMax =
					Arrays.asList(precioMaxListCel,precioMaxListTel,precioMaxListVent);
		
		listadoPreciosMax.forEach(System.out::println);
		
	}

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class ComponenteElectronico02{
	
	//caracteristicas sucintas
	long id;
	String marca;
	String nombre;
	int precio;
}
