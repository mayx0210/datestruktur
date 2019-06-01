package com.myx.datestruct.stack
import scala.util.control.Breaks._

//定义一个双向链表模拟栈
class LinkedStack(linkedMaxSize:Int) {
  //定义一个头结点
  val head = new LinkedNode(0)
  var top = null
  val maxSize = linkedMaxSize
  var count = -1
  //空栈
  def isEmpty():Boolean = {
    head.next == null
  }
  def isFull():Boolean = {
    count == maxSize - 1
  }
  //入栈
  def push(num:Int): Unit ={
    val linkedNode = new LinkedNode(num)
    if (isFull()){
      println("栈满，不能入栈")
      return
    }
    var top = head
    breakable{
      while (true){
        if (top.next == null){
          break()
        }
        top = top.next
      }
    }
    top.next = linkedNode
    linkedNode.pre = top
    top = top.next
    count += 1
  }
  //出栈
  def pop(): Any = {
    if (isEmpty()){
      return new Exception("空栈")
    }
    var top = head
    breakable{
      while (true){
        if (top.next == null){
          break()
        }
        top = top.next
      }
    }
    val temp = top
    top.pre.next = null
    count -= 1
    top = top.pre
    return temp.no
  }

  //遍历链表
  def show(): Unit ={
    if (isEmpty()){
      return new Exception("空栈")
    }
    var top = head
    breakable{
      while (true){
        if (top.next == null){
          break()
        }
        top = top.next
      }
    }
    breakable{
      while (true){
        if (top.pre == null){
          break()
        }
        printf("%d\n",top.no)
        top = top.pre
      }
    }
  }

  def peek(): Any ={
    if (isEmpty()){
      return new Exception("空栈")
    }
    var top = head
    breakable{
      while (true){
        if (top.next == null){
          break()
        }
        top = top.next
      }
    }
    return top.no
  }
}
