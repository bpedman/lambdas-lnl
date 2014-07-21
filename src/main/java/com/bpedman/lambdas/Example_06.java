package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_06
{
  /**
   * Our nice, readable, functional prime number checker
   */
  private static boolean isPrime(final int number)
  {
    IntPredicate numberIsDivisible = (divisor) -> number % divisor == 0;

    return number > 1 &&
        IntStream
            .range(2, number - 1)
            .parallel()
            .noneMatch(numberIsDivisible);
  }

  private static boolean isGreaterThan5(final int number)
  {
    return number > 5;
  }

  private static int doubleIt(final int number)
  {
    return number * 2;
  }

  /**
   * Using simple functions that perform one duty we can make the complex calculation below even
   * more understandable. It is now very declarative what we are trying to accomplish
   *
   * @param numbers
   *          potentially unordered, non-unique set of numbers
   */
  public static int findDoubleOfFirstPrimeNumberGreaterThan5(List<Integer> numbers)
  {
    return numbers
        .stream()
        .filter(Example_06::isPrime)
        .filter(Example_06::isGreaterThan5)
        .map(Example_06::doubleIt)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static void main(String[] args)
  {
    System.out.println(findDoubleOfFirstPrimeNumberGreaterThan5(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
  }
}
