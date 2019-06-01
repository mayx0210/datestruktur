package com.myx.datestruct.stack

import scala.io.StdIn

object LinkedStackDemo {
  def main(args: Array[String]): Unit = {
    val stack = new LinkedStack(3)
    var key =""
    while (true){
      println("请选择以下操作")
      println("push:入栈操作、pop：出栈操作、show：遍历栈、peek：查看栈顶元素、q：退出")
      key = StdIn.readLine()
      key match {
        case "push" =>
          println("请输入一个整数")
          val num = StdIn.readInt()
          stack.push(num)
        case "pop" =>
          val res = stack.pop()
          if(res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            println()
            printf("取出栈顶的值是%d\n", res)
          }
        case "peek" =>
          val res = stack.peek()
          if(res.isInstanceOf[Exception]) {
            println(res.asInstanceOf[Exception].getMessage)
          }else{
            println()
            printf("栈顶的值是%d\n", res)
          }
        case "show" =>
          stack.show()
        case "q" =>
          return
      }
    }
  }
}
