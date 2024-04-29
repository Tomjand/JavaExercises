package org.exercise;

import org.exercise.abstrac.Abstrac;
import org.exercise.arrayvsarraylist.ArrayLinkVsArraylist;
import org.exercise.generictype.GenericType;
import org.exercise.streamexception.StreamException;
import org.exercise.records.RecordsExercice;
import org.exercise.enums.EnumsDemo;

public class Main
{
	public static void main(final String[] args)
	{
		final GenericType genericType = new GenericType();
		genericType.start();

		final ArrayLinkVsArraylist arrayLinkVsArraylist = new ArrayLinkVsArraylist();
		arrayLinkVsArraylist.start();

		 final Abstrac abstrac = new Abstrac();
		 abstrac.start();

		// final StreamException streamException = new StreamException();
		 //streamException.start();

		 final RecordsExercice recordsExercises = new RecordsExercice("test", 12);
		 System.out.println(recordsExercises.txt());
		 System.out.println(recordsExercises.number());

		final EnumsDemo enumsDemo = new EnumsDemo();
		enumsDemo.start();
	}
}
