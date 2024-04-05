package org.exercise.streamexception;

import java.util.stream.IntStream;

public class StreamException
{
	public void start()
	{
		System.out.println("=============== Stream Exception: ==============");
		loopNumbers();
		loopNumbersStream();
		loopNumbersStreamWithUnchcekedException();
		loopNumbersStreamWithChcekedException();
	}

	private void loopNumbers()
	{
		final int[] numbers = {1, 2, 3, 4, 5};
		for (int i = 0; i <= numbers.length-1; i++)
		{
			if (i == 3)
			{
				System.out.println("i is 3");
			}
			System.out.println(numbers[i]);
		}
	}

	private void loopNumbersStream()
	{
		final int[] numbers = {1, 2, 3, 4, 5};

		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         if (i == 3) {
				         System.out.println("i is 3");
			         }
			         System.out.println("stream: " + numbers[i]);
		         });
	}

	public void loopNumbersStreamWithUnchcekedException()
	{
		final int[] numbers = {1, 2, 3, 4, 5};

		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         if (i == 3) {
				         throw new RuntimeException("i is 3");
			         }
			         System.out.println("stream: " + numbers[i]);
		         });
	}

	public void loopNumbersStreamWithChcekedException()
	{
		final int[] numbers = {1, 2, 3, 4, 5};

		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         if (i == 5) {
				         throw new myException("myException i  is 5");
			         }
			         System.out.println("stream: " + numbers[i]);
		         });
	}

}
