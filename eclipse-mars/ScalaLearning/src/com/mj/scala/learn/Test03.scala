package com.mj.scala.learn
/**
 * apply ： 语法糖
 * object ： 代表的是 module, 是可以单独运行的
 */
object Test03 {
  def main(args: Array[String]): Unit = {
    val foo = FooMaker()
    println(foo)
    val bar = new Bar
    println(bar())
  }
}
  class Foo {}

  object FooMaker {
    def apply() = new Foo
  }

  class Bar {
    def apply() = 0
  }