/*
    Tutorial 11: Imperative Programming with Scala

    There is no need to submit this tutorial.

    To compile you may use:
    fsc Tut11.scala

    To run:
    scala Tut11

    Package manager is "sbt" which you may try to
    install on your machine, e.g.
    sudo apt-get install sbt
*/

object Tut11 {
  
    /*
        Q1: Consider a tail-recursive method.
        Re-implement this method using an iterative loop together
        with two var values that are internal to the method
    */
  
    def fib(n: Int): Int = {
        def aux(n: Int, a: Int, b: Int): (Int, Int) =
            if (n <= 1) (a, b)
            else aux(n - 1, a + b, a)
        aux(n, 1, 0)._1
    }

    def print_fib() = 
        for (i <- 1 to 50) {
            println("Fib" + i + ":" + fib(i));
        }
  
    def fib_imp(n: Int): Int = {
        var a = 1
        var b = 0
        throw new Error("fib_imp: TBI")
        while (true) {
            // use a while loop here
            // but note that n is immutable.
        }
        a
    }

    def print_fib_imp() = 
        for (i <- 1 to 20) {
            println("Fib" + i + ":" + fib_imp(i));
        }

/* 
    Q2: Implement fib function with memoization using a hash table.
    How does this compares with your implementation in Q1?
*/

    def fib_memo(n: Int): Int = {
        val map = scala.collection.mutable.HashMap.empty[Int,Int]
        // map is immutable reference to a mutable object
        // method map.contains(a)
        // method map.+=(a->b)
        // you may use infix and post-fix notations
        // map contains a
        // map += (a -> b)
        def aux(n: Int): Int =
            if (n <= 1) n
            else {
                val r = aux(n - 1) + aux(n - 2)
                r
            }
        aux(n)
    }

    def print_fib_memo() = 
        for (i <- 1 to 50) {
          println("Fib" + i + ":" + fib_memo(i));
        }

    /*
        Q3: Design a imperative stack in Scala that is polymorphic.
        Could you do the same in OCaml?
    */

    class Stack[A] {
        var stk: List[A] = List()
        // mutable field to an immutable list
        def push(x: A): Unit = {
            throw new Error("push: TBI")
        }
        def pop():A = {
            throw new Error("push: TBI")
        }
        def length(): Int = throw new Error("length: TBI")
        override def toString: String =
            "Stack:" + stk + "\n"
    }

    def main(args: Array[String]) {
        print_fib()
        // print_fib_imp()
        // print_fib_memo()
        val stk = new Stack[Int]
        stk.push(1);
        stk.push(2);
        println("Current stack is" + stk)
    }
}
