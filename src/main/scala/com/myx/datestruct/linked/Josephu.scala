package com.myx.datestruct.linked

import scala.util.control.Breaks._
class Josephu {

  var first:Boy = null
  //添加小孩形成闭环链表
  def addBoy(boyNums:Int): Unit ={
    var curBoy:Boy = null
    for (i <- 1 to boyNums){
      //创建小孩对象
      val boy = new Boy(i)
      //处理第一个小孩，就形成环形
      if ( i == 1){
        first = boy
        curBoy = boy
        first.next = first
      }else{
        curBoy.next = boy
        boy.next = first
        curBoy = boy
      }
    }
  }

  //遍历环形链表
  def list(): Unit ={
    //判断链表是否为空
    if(first == null){
      return
    }
    var curBoy = first
    breakable{
      while (true){
        printf("no=%d\n",curBoy.no)
        if (curBoy.next == first){
          //表示curBoy已经是最后一个
          break()
        }
        curBoy = curBoy.next
      }
    }
  }
  //小孩数数
  def countBoy(startNO:Int,countNum:Int,boyNums:Int): Unit ={
    //数据输入验证
    if (first == null || startNO > boyNums || startNO <= 0){
      println("输出参数有误，不能玩游戏")
      return
    }

    //创建一个辅助指针helper，使helper在first前面
    var helper = first
    breakable{
      while (true){
        if (helper.next == first){
          break()
        }
        helper = helper.next
      }
    }
    for (i <- 0 until startNO - 1){
      first = first.next
      helper = helper.next
    }
    breakable{
      while (true){
        //判断是否只剩下一个孩子了
        if (helper == first){
          break()
        }
        for (i <- 0 until countNum - 1){
          first = first.next
          helper = helper.next
        }
        printf("出圈的小孩编号：%d\n",first.no)
        first = first.next
        helper.next = first
      }
    }
    printf("最后留在圈中的小孩编号是：%d\n",first.no)
  }

  //小孩数数方法二
  def countBoy1(startNO:Int,countNum:Int,boyNums:Int): Unit ={
    //数据输入验证
    if (first == null || startNO > boyNums || startNO <= 0){
      println("输出参数有误，不能玩游戏")
      return
    }

    //创建一个辅助指针helper，使helper在first前面
    var helper = first
    breakable{
      while (true){
        if (helper.next == first){
          break()
        }
        helper = helper.next
      }
    }
    for (i <- 0 until startNO - 1){
      helper = helper.next
    }
    breakable{
      while (true){
        //判断是否只剩下一个孩子了
        if (helper == helper.next){
          break()
        }
        for (i <- 0 until countNum - 1){
          helper = helper.next
        }
        printf("出圈的小孩编号：%d\n",helper.next.no)
        helper.next = helper.next.next
      }
    }
    printf("最后留在圈中的小孩编号是：%d\n",helper.no)
  }
}
