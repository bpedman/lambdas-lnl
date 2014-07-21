package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_05
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
            .noneMatch(numberIsDivisible);
  }

  /**
   * Using the stream API and re-using isPrime we can make the code more readable, maintainable, and
   * section each step into a separate piece of work....but, it could be made even more readable or
   * declarative than this by using some utility methods with method references...
   *
   * @param numbers
   *          potentially unordered, non-unique set of numbers
   */
  public static int findDoubleOfFirstPrimeNumberGreaterThan5(List<Integer> numbers)
  {
    return numbers
        .stream()
        .filter(Example_05::isPrime)
        .filter((i) -> i > 5)
        .map((i) -> i * 2)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static void main(String[] args)
  {
    System.out.println(findDoubleOfFirstPrimeNumberGreaterThan5(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
  }
}
