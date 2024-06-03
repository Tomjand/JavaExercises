package org.exercise.abstrac;

public class Bird extends Animal
{
	private String infoBird = "birdInfo";

	public Bird(final String infoBird)
	{
		super("fromBird");
		this.infoBird = infoBird;
	}


	public void fly()
	{
		System.out.println(infoBird);
	}
}
