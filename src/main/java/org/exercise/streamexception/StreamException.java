package org.exercise.streamexception;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class StreamException
{
	public void start()
	{
		System.out.println("=============== Stream Exception: ==============");
		loopNumbers();
		loopNumbersStream();
		loopNumbersStreamWithUncheckedException();
		loopNumbersStreamWithCheckedException();
		loopNumbersStreamWithCheckedExceptionWithHandleEx();
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
			         if (i == 2) {
				         System.out.println("i is 2");
			         }
			         System.out.println("stream: " + numbers[i]);
		         });
	}

	private void loopNumbersStreamWithUncheckedException()
	{
		final int[] numbers = {1, 2, 3, 4, 5};
//zamienic na Array i numbers
		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         if (i == 3) {
				         //throw new RuntimeException("i is 3");
			         }
			         System.out.println("stream UN: " + numbers[i]);
		         });
	}

	private void loopNumbersStreamWithCheckedException()
	{
		final int[] numbers = {1, 2, 3, 4, 5};

		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         if (i == 4) {
				         //anty pattern
						 try {
					         throw new myException("myException i  is 4");
				         } catch (final myException e) {
					         e.printStackTrace();
				         }
			         }
			         System.out.println("stream CH: " + numbers[i]);
		         });
	}

	private Integer myStreamUtils(final int i)
	{
		try
		{
			if (i == 4)
			{
				throw new myException("myException i  is 4");
			}
			else
			{
				return i;
			}
		}
		catch(myException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private void loopNumbersStreamWithCheckedExceptionWithHandleEx()
	{
		final int[] numbers = {1, 2, 3, 4, 5, 6, 7};

		IntStream.range(0, numbers.length)
		         .forEach(i -> {
			         myStreamUtils(i);
			         myStreamUtilsOptional(i);
			         System.out.println("stream CH: " + numbers[i]);
		         });
	}

	private Optional<Integer> myStreamUtilsOptional(final int i)
	{
		try
		{
			if (i == 6)
			{
				throw new myException("myException i  is 6");
			}
			else
			{
				return Optional.of(i);
			}
		}
		catch(myException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//public static <T,R> Function<T,R> wrapper(final CheckedFunction<T,R> checkedFunction) {
	//	return t -> {
	//		try {
	//			return checkedFunction.apply(t);
	//		} catch (final myException e) {
	//			e.printStackTrace();
	//		}
	//	};
	//}
//Zapoznac sie z:
	//1.apache-lang
	// 2. apache-commons
	//3. sterowanie wyjatkami


}
