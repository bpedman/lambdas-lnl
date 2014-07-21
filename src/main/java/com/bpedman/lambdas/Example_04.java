package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_04
{
  /**
   * Lambdas can be saved as variables just like any other type. This is what allows us to pass
   * lambdas as arguments and return them from methods.
   *
   * This is much better and more readable now, now lets look below and see what we can do to get
   * rid of the sequential nature of findDoubleOfFirstPrimeNumberGreaterThan5 and make it more
   * readable.
   */
  private static boolean isPrime(final int number)
  {
    IntPredicate numberIsDivisible = (divisor) -> number % divisor == 0;

    return number > 1 &&
        IntStream
            .range(2, number - 1)
            .noneMatch(numberIsDivisible);
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
