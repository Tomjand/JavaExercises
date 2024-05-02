package org.exercise.enums;

public class EnumsDemo
{
	public void start()
	{
		System.out.println("================= EnumsDemoEnum 1 =================");
		for (final EnumsDemoEnum enumsDemoEnum : EnumsDemoEnum.values())
		{
			System.out.println(enumsDemoEnum.getValue() + " " + enumsDemoEnum.name() + " " + enumsDemoEnum.getValue()+ " " + enumsDemoEnum.getColor());

		}

		EnumsDemoEnum.StaticMtehod();

		System.out.println("================= EnumsDemoEnum 2 =================");

		final EnumsDemoEnum methodNoStatic1 = EnumsDemoEnum.INFO;
		methodNoStatic1.y2();

	}

}
