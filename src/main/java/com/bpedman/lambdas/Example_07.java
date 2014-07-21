package com.bpedman.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Experimental class...see comments through code for different things to try
 *
 * @author Brandon Pedersen &lt;bpedersen@getjive.com&gt;
 */
public class Example_07
{
  /**
   * Our nice, readable, functional prime number checker
   */
  private static boolean isPrime(final int number)
  {
    System.err.println("isPrime " + number);
    IntPredicate numberIsDivisible = (divisor) -> number % divisor == 0;

    return number > 1 &&
        IntStream
            .range(2, number - 1)
            .parallel()
            .noneMatch(numberIsDivisible);
  }

  private static boolean isGreaterThan5(final int number)
  {
    System.err.println("isGT " + number);
    return number > 5;
  }

  private static int doubleIt(final int number)
  {
    System.err.println("double " + number);
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
        // What will be printed out on the console after running this?
        .stream()
        // What will happen if we use a parallel stream?
        // .parallel()
        .filter(Example_07::isPrime)
        .filter(Example_07::isGreaterThan5)
        .map(Example_07::doubleIt)
        // What will be printed if we comment out the findFirst() operation?
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

  public static void main(String[] args)
  {
    // Will this program ever finish if the stream is parallel
    // i.e. will it ever find 11 as matching the first value before 7?
    int num = 0;
    do
    {
      num = findDoubleOfFirstPrimeNumberGreaterThan5(
          Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
    }
    while (num == 14);

    System.out.println(num);
  }
}
