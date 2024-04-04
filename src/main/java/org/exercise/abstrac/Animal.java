package org.exercise.abstrac;


public abstract class Animal implements Serializable
{
	String info;
	protected Animal(final String info){
		this.info = info;
	}

	public void toLetter(){
		System.out.println("toLetter from Animal");
	}

	public void live(){
		System.out.println("Animal live" + info);
	}
}
