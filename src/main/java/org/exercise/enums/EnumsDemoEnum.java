package org.exercise.enums;

public enum EnumsDemoEnum
{
	INFO(1, "Msg info", 0x0000AA),
	WARN(2, "Msg warn", 0xBB0000),
	ERROR(3, "Msg error", 0xFF00CC);

	private final int value;
	private final String msg;
	private final int color;

	EnumsDemoEnum(final int value, final String msg, final int color)
	{
		this.value = value;
		this.msg = msg;
		this.color = color;
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

}
