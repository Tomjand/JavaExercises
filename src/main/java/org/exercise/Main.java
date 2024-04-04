package org.exercise;

import org.exercise.abstrac.Abstrac;
import org.exercise.arrayvsarraylist.ArrayLinkVsArraylist;
import org.exercise.generictype.GenericType;

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
	}
}
