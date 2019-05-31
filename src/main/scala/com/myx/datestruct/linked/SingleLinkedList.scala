package com.myx.datestruct.linked

import scala.util.control.Breaks._
class SingleLinkedList {

  //定义一个头节点，头节点不能动
  val head = new HeroNode(0,"","")
  //添加节点到单向链表
  def addList(heroNode: HeroNode): Unit ={
    //定义一个临时节点
    var temp = head
    breakable{
      while(true){
        if (temp.next == null){
          break()
        }
        temp = temp.next
      }
    }
    temp.next = heroNode
  }

  //按照顺序从小到大添加节点
  def addBySort(heroNode: HeroNode): Unit ={
    var temp = head
    var flag = false
    breakable{
      while (true){
        if (temp.next == null){
          flag = true
          break()
        }
        if (temp.next.no > heroNode.no){
          flag = true
          break()
        }else if (temp.next.no == heroNode.no){
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      heroNode.next = temp.next
      temp.next = heroNode
    }else{
      println("英雄的排名已经存在")
      return
    }
  }

  //更新节点
  def updateList(heroNode: HeroNode): Unit ={
    if (head.next == null){
      println("链表为空，不能遍历")
      return
    }
    var temp = head.next
    var flag = false
    breakable{
      while (true){
        if (temp.no == heroNode.no){
          flag = true
          break()
        }
        if (heroNode.no == null){
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      temp.name = heroNode.name
      temp.nickname = heroNode.nickname
    }else{
      print("编号为%d的节点不存在",heroNode.no)
    }
  }
  //删除节点
  def deleteList(heroNode: HeroNode): Unit ={
    if (head.next == null){
      println("空链表，不能删除")
      break()
    }
    var temp = head
    var flag = false
    breakable{
      while (true){
        if (temp.next.no == heroNode.no){
          flag = true
          break()
        }
        if (heroNode.no == null){
          break()
        }
        temp = temp.next
      }
    }
    if (flag){
      temp.next = temp.next.next
    }else{
      println("删除链表的节点%d不存在",heroNode.no)
    }
  }
  //遍历节点
  def showList(): Unit ={
    //检测是否是空链表，如果是就就直接退出
    if (head.next == null){
      println("链表为空")
      return
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
