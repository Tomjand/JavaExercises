package org.exercise.generictype;

import java.util.ArrayList;
import java.util.List;

import org.exercise.abstrac.Animal;
import org.exercise.abstrac.Bird;
import org.exercise.abstrac.Fish;


public class GenericType
{
	private static <T, V> T shout(final T input, final V input2)
	{
		System.out.println(input + "!!!!!");
		System.out.println(input2);
		return input;
	}

	private static void printList(final List<? extends Animal> myList)
	{
		System.out.println(myList);
	}

	public void start()
	{
		System.out.println("=============== Generics Type: ==============");


		final ArrayList<Bird> birds = new ArrayList<>();
		birds.add(new Bird("birdInList"));

		final Bird myBirds = birds.get(0);
		myBirds.fly();

		final Printer<Fish> newFishPrinter = new Printer<>(new Fish("wow fish"));
		newFishPrinter.print();
		newFishPrinter.input.swim();
		newFishPrinter.input.live();

		shout("test teste", 45);

		final List<Bird> birdsList = new ArrayList<>();
		birdsList.add(new Bird("bird-1"));
		printList(birdsList);

	}
}
