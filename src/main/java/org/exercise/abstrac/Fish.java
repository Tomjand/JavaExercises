package org.exercise.abstrac;

import org.exercise.abstrac.Animal;

public class Fish extends Animal
{

	private final String infoFish;

	public Fish(final String infoFish){
		super("fromFish");
		this.infoFish = infoFish;
	}

	@Override
	public void toLetter()
	{
		System.out.println("from Bird toLetter");
	}

	public void swim(){
		System.out.println(this.infoFish);
	}
}
