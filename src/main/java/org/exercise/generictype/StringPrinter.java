package org.exercise.generictype;

public class StringPrinter
{
	String stringToPrint;

	public StringPrinter(final String stringToPrint)
	{
		this.stringToPrint = stringToPrint;
	}

	void print()
	{
		System.out.println(stringToPrint);
	}
}
