package org.exercise.streamexception;

@FunctionalInterface
public interface CheckedFunction<T, R>
{
	R apply(T t) throws myException;
}
