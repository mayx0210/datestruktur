package com.myx.datestruct.queue

class CircleArrayQueue(arrMaxSize: Int) {
  var front = 0
  var rear = 0
  val maxSize = arrMaxSize
  val arr = new Array[Int](arrMaxSize) //队列的数据存放的数组

  //判断队列是否空
  def isEmpty(): Boolean = {
    front == rear
  }

  //判断队列是否满
  def isFull(): Boolean = {
    front == (rear + 1) % maxSize
  }

  //添加元素
  def addQueue(num: Int): Unit = {
    if (isFull()) {
      println("队列满，不能加入")
      return
    }
    //先把数据存入到arr(rear)位置，然后后移rear
    arr(rear) = num
    rear = (rear + 1) % maxSize
  }

  //删除元素
  def deleteQueue(): Any = {
    if (isEmpty()){
      return new Exception("队列空，没有数据")
    }
    var temp = arr(front)
    front = (front + 1 ) % maxSize
    return temp
  }

  //遍历队列
  def showQueue(): Unit ={
    if (isEmpty()) {
      println("队列空")
      return
    }
    for (i <- front until (front + size)){
      printf("arr(%d)=%d\t",i,arr(i))
    }
  }

  def size(): Int ={
    return (rear + maxSize - front) % maxSize
  }

  def peek(): Any ={
    if (isEmpty()){
      return new Exception("队列空，没有数据")
    }
    return arr(front)
  }
}
