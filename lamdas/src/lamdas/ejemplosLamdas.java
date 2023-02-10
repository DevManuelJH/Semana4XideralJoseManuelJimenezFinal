package lamdas;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ejemplosLamdas {

	public static void main(String[] args) {

		System.out.println("Lambda para generar numeros del 1-10");

		IntStream.rangeClosed(1, 10).forEach(n -> System.out.println(n));

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para filtar numeros pares de una lista del 1-10");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para calcular el IVA");

		double ivaPorcentaje = 21.0;
		Function<Double, Double> CalcularIva = monto -> monto * ivaPorcentaje / 100.0;

		double amount = 100.0;
		double iva = CalcularIva.apply(amount);
		System.out.println("el precio con IVA es: " + iva);

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para generar la fecha actual");

		Supplier<LocalDate> generaFecha = () -> LocalDate.now();

		LocalDate fechaAct = generaFecha.get();
		System.out.println("fecha Actual : " + fechaAct);

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para determinar si una persona es mayor de edad");

		List<Persona> persona = Arrays.asList(new Persona("John", 15), new Persona("Jane", 25), new Persona("Jim", 17));

		int ageThreshold = 18;
		Predicate<Persona> isOlderThan = person -> person.getEdad() > ageThreshold;

		persona.stream().filter(isOlderThan).forEach(person -> System.out.println(person.getNombre()));

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para filtrar por la primer letra de tu nombre");

		List<String> nombres = Arrays.asList("jose", "jenny", "manuel", "max");

		Predicate<String> startsWithJ = nombre -> nombre.charAt(0) == 'J' | nombre.charAt(0) == 'j';

		nombres.stream().filter(startsWithJ).forEach(System.out::println);

		System.out.println("--------------------------------\n");

		System.out.println("Lambda para sumar dos arreglos en java");

		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {5, 4, 3, 2, 1};

		IntBinaryOperator sumaArrays = (x, y) -> x + y;

		int[] sum = IntStream.range(0, array1.length)
		        .map(i -> sumaArrays.applyAsInt(array1[i], array2[i]))
		        .toArray();

		System.out.println("la Suma de los arrays es: " + Arrays.toString(sum));

	}
}
