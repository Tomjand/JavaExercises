package org.exercise.generictype;

import org.exercise.abstrac.Animal;
import org.exercise.abstrac.Serializable;

public class Printer<T extends Animal & Serializable>
{
	T input;
	public Printer(final T input ){
		this.input = input;
	}
	void print(){
		input.live();
		System.out.println("Printer " + input);
	}
}
