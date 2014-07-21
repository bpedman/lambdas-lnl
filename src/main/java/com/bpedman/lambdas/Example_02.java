package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_02
{
  /**
   * Check if number is prime using an IntStream which removes the sequential nature and allows a
   * bit more readability and flexibility.
   *
   * Now we can transform the anonymous inner class predicate into a lambda to improve readability
   * even more.
   */
  private static boolean isPrime(final int number)
  {
    return number > 1 &&
        IntStream
            .range(2, number - 1)
            .noneMatch(new IntPredicate()
            {
              @Override
              public boolean test(final int value)
              {
                return number % value == 0;
              }
            });
  }

  /**
   * Our goal...turn this set of calculations into something that is as readable as the method name
   * itself and more succinct than it is
   *
   * @param numbers
   *          potentially unordered, non-unique set of numbers
   */
  public static int findDoubleOfFirstPrimeNumberGreaterThan5(List<Integer> numbers)
  {
    int result = 0;
    for (final Integer number : numbers)
    {
      // first check if prime
      if (isPrime(number))
      {
        if (number > 5)
        {
          result = number * 2;
        }
      }
    }

    return result;
  }

  public static void main(String[] args)
  {
    System.out.println(findDoubleOfFirstPrimeNumberGreaterThan5(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
  }
}
