package com.myx.datestruct.linked
import scala.util.control.Breaks._

//定义一个带头结点的双向链表
class DoubleLinkedList {
    //定义头节点并且头节点不能动
  val head = new HeroNode1(0,"","")

  //增加节点到双向链表
  def add(heroNode1: HeroNode1): Unit ={
    var temp = head
    breakable{
      while (true){
        if (temp.next == null){
          break()
        }
        temp = temp.next
      }
    }
    temp.next = heroNode1
    heroNode1.pre = temp
  }

  //更新双向链表的节点
  def update(heroNode1: HeroNode1): Unit ={
    if (head.next == null){
      println("链表为空")
      break()
    }
    var temp = head
    var flag = false
    breakable{
      while (true){
        if (temp.next.no == heroNode1.no){
          flag = true
          break()
        }
        if (temp.next == null){
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      temp.next.name = heroNode1.name
      temp.next.nickname = heroNode1.nickname
    }else{
      printf("你要修改的%d英雄不存在.", heroNode1.no)
    }
  }

  //删除双向链表中的节点
  def delete(no:Int): Unit ={
    if (head.next == null){
      println("链表为空")
      break()
    }
    var temp = head.next
    var flag = false
    breakable{
      while (true){
        if (temp.no == no){
          flag = true
          break()
        }
        if (temp.next == null){
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      temp.pre.next = temp.next
      if (temp.next != null){
        temp.next.pre = temp.pre
        temp.next = null
      }
    }else{
      println("你要删除的no=%d 结点不存在\", no")
    }

  }

  //遍历双向链表
  def show(): Unit ={
    if (head.next == null){
      println("链表为空")
      break()
    }
    var temp = head.next
    breakable{
      while (true){
        printf("节点信息为：no=%d name=%s,nickname=%s\n",temp.no,temp.name,temp.nickname)
        if (temp.next == null){
          break()
        }
        temp = temp.next
      }
    }
  }
}
