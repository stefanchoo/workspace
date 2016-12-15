package com.mj.scala.learn

object Test01 {

  def main(args: Array[String]): Unit = {
    println("Hello World")
    println(add) // 无参数调用可以不带括号
    println(adder(1, 2)) // 有参函数调用
    val add2 = adder(2, _:Int)       // 部分应用, _表示通配符
    
    println(add2)        // output => function1 => 2 + m
    
    println(add2(3))     // output => 2 + 3 = 5
    
    var addOne = (m: Int) => m + 1 // 匿名函数
    println(addOne(1))
    
    println(multiply(2)(3))
    
    /*
     * 柯里化函数：允许别人一会在你的函数上应用一些参数，然后又应用另外的一些参数
     * 实例： 2 由 乘数 -> 被乘数
     */
    var times2 = multiply(2) _
    println(times2(3))
    
    (adder _).curried
  }

  def add() = 1 + 2
  def adder(m: Int, n: Int): Int = m + n
  def multiply(m: Int)(n: Int): Int = m * n
}