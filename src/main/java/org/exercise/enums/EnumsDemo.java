package org.exercise.enums;

public class EnumsDemo
{
	public void start()
	{
		System.out.println("================= EnumsDemoEnum =================");
		for (final EnumsDemoEnum enumsDemoEnum : EnumsDemoEnum.values())
		{
			System.out.println(enumsDemoEnum.getValue() + " " + enumsDemoEnum.name() + " " + enumsDemoEnum.getValue()+ " " + enumsDemoEnum.getColor());

		}
	}

}
