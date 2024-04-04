package org.exercise.arrayvsarraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ArrayLinkVsArraylist
{
	public void start(){
		System.out.println("================ ArrayLinkVsArraylist =================");

		final String[] pepoleArray = {"Ann", "Jan", "Rob"};
		System.out.println(pepoleArray[0]);

		final ArrayList<String> pepoleList = new ArrayList<>(Arrays.asList("A","B","C"));
		System.out.println(pepoleList);
		pepoleList.add("p1");
		pepoleList.add("p2");
		pepoleList.add("p3");
		pepoleList.add(1, "p1.5");

		final LinkedList<String> namesLinkedList = new LinkedList<>();
		namesLinkedList.add("name1");
		namesLinkedList.add("name2");
		namesLinkedList.add("name3");
		namesLinkedList.add(1, "name1.5");

	}

}
