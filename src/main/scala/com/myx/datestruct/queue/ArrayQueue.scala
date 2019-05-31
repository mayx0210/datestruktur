package com.myx.datestruct.queue

//定义一个类ArrayQueue表示队列
//实现增、删、改、查
class ArrayQueue(arrMaxSize:Int){
  val maxSize = arrMaxSize;
  val arr = new Array[Int](maxSize)
  var front = -1;//表示队列的第一个元素的前一个位置
  var rear = -1;//表示队列的最后一个元素


  //判断队列是否为空
  def isEmpty():Boolean = {
    rear == front
  }

  //判断队列是否满
  def isFull():Boolean = {
    rear == maxSize - 1
  }

  //添加元素
  def addQueue(num:Int): Unit ={
    if (isFull()){
      println("队列已满，不能再添加元素")
      return
    }

    //尾指针向后移动一位
    rear += 1
    arr(rear) = num
  }

  //删除元素
  def deleteQueue():Any ={
    if (isEmpty()){
      return new Exception("队列空，没有数据")
    }
    //头指针向后移动
    front += 1
    return arr(front)
  }

  //遍历队列
  def showQueue(): Unit ={
    if (isEmpty()){
      println("队列为空")
      return
    }
    for (i <- (front + 1) to rear) {
      printf("arr(%d)=%d\t",i,arr(i))
    }
    println()
  }

  //查看队列的头元素，但是不取出
  def peek():Any = {
    if (isEmpty()){
      return new Exception("队列空，没有数据返回")
    }
    return arr(front + 1)
  }
}
