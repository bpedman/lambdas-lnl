package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_01
{
  /**
   * Traditional way to check if a number is prime
   *
   * Multiple return points here, sequential in nature, if number is large this can take a long time
   */
  private static boolean isPrime(final int number)
  {
    if (number < 2)
    {
      return false;
    }
    for (int i = 2; i < number; i++)
    {
      if (number % i == 0)
      {
        return false;
      }
    }
    return true;
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
