package org.exercise.enums;

public enum EnumsDemoEnum
{
	INFO(1, "Msg info", 0x0000AA),
	WARN(2, "Msg warn", 0xBB0000),
	ERROR(3, "Msg error", 0xFF00CC),
	TRACE(4, "Msg trace");
	private final int value;
	private final String msg;
	private final int color;

	EnumsDemoEnum(final int value, final String msg, final int color)
	{
		this.value = value;
		this.msg = msg;
		this.color = color;

	}

	EnumsDemoEnum(final int value, final String msg)
	{
		this.value = value;
		this.msg = msg;
		this.color = 0x0000AA;
	}

	public int getValue()
	{
		return value;
	}

	public String getMsg()
	{
		return msg;
	}

	public int getColor()
	{
		return color;
	}

	public static String StaticMtehod(){
		final EnumsDemoEnum methodNoStatic = EnumsDemoEnum.INFO;
		methodNoStatic.y2();
		System.out.println("test from x: static method");
		return "test from x";
	}

	public String y2 (){
		System.out.println("test from y");
		return "test from y";
	}

}
