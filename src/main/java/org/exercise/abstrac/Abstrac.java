package org.exercise.abstrac;

public class Abstrac
{
	public void start()
	{
		System.out.println("=============== Abstrac: ==============");
		final Bird newBird = new Bird("new Bird");
		newBird.fly();
		newBird.live();
		System.out.println(newBird.info);
	}
}
