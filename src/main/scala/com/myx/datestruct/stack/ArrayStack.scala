package com.myx.datestruct.stack
//使用数组模拟栈
class ArrayStack(arrMaxSize:Int) {
  val maxSize = arrMaxSize
  val arr = new Array[Int](arrMaxSize)

  //栈顶
  var top = -1
  //判断栈空
  def isEmpty(): Boolean ={
    top == -1
  }

  //判断栈满
  def isFull(): Boolean = {
    top == maxSize - 1
  }

  //入栈
  def push(num:Int): Unit ={
    if (isFull()){
      println("栈满，不能进栈")
      return
    }
    top += 1
    arr(top) = num
  }

  //出栈
  def pop(): Any ={
    if (isEmpty()){
      return new Exception("空栈")
    }
    //将top指向的值保存到临时变量
    val res = arr(top)
    top -= 1
    return res
  }

  //遍历栈
  def show(): Unit ={
    if (isEmpty()){
      return new Exception("空栈，不能遍历")
    }
    //逆序遍历
    for (i <- 0 to top reverse){
      printf("arr(%d)=%d\n",i,arr(i))
    }
  }
  //查看栈顶元素
  def peek(): Any ={
    if (isEmpty()){
      return new Exception("空栈")
    }

    return arr(top)
  }
}
