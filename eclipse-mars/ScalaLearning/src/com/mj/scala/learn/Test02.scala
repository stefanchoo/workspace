package com.mj.scala.learn

/**
 * @author stefan
 * 特质： 类似接口
 */
trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}

class Test02 extends Car{
  val brand = "BMW"
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val shineRefraction = 12
  
  // 方法中引入泛型
  def remove[K](key: K) {}
}


trait Cache[K, V] {
  def get(key: K):V
  def put(key: K, value: V)
  def remove(key: K, value: V)
  def delete(key: K)
}



