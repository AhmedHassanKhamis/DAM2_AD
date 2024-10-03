package org.dam2.ejercicioTraders;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		Consumer<Transaction> transactionEscribidor = System.out::println;
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");

		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
//		1. Find all transactions in the year 2011 and sort them by value (small to high).
		
//		transactions.stream().filter(t -> t.getYear() == 2011).sorted((t1,t2) -> t1.getValue() - t2.getValue()).forEach(System.out::println);

//		2. What are all the unique cities where the traders work?
		
//		transactions.stream()
//					.map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);;
		
		
//		3. Find all traders from Cambridge and sort them by name.
				
//		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getTrader).map(Trader::getName).distinct().sorted(String::compareTo).forEach(System.out::println);;
			
//		4. Return a string of all traders' names sorted alphabetically.
//		System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted(String::compareTo).reduce("",(n1,n2)->n1 + n2));
		
//		5. Are any traders based in Milan?
		
//		System.out.println(transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equalsIgnoreCase("milan")));
//		
		
//		6. Print all transactions' values from the traders living in Cambridge.
		
//		transactions.stream().filter(t -> t.getTrader().getCity().equalsIgnoreCase("cambridge")).map(Transaction::getValue).forEach(System.out::println);
		
//		7. What's the highest value of all the transactions?
		
//		transactions.stream()
//					.mapToInt(Transaction::getValue)
//					.max()
//					.ifPresent(System.out::println);;
//		
//		8. Find the transaction with the smallest value.
		
//					transactions.stream()
//					.mapToInt(Transaction::getValue)
//					.min()
//					.ifPresent(System.out::println);;
//		
//		9. Mostrar el total de las transacciones por la ciudad de los agentes. Intentar ordenar por cantidad.
				Comparator<Entry<String, Integer>> comparador = Entry.comparingByValue();
				comparador = comparador.reversed();
				
					transactions.stream()
					.collect(Collectors.groupingBy(t -> t.getTrader().getCity(),Collectors.summingInt(Transaction::getValue)))
					.entrySet().stream()
					.sorted(comparador)
					.forEach(System.out::println);
		
		
	}

}
