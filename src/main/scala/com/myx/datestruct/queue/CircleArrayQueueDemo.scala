package com.myx.datestruct.queue

import scala.io.StdIn

object CircleArrayQueueDemo {
    def main(args: Array[String]): Unit = {
      //创建一个队列对象
      val queue = new CircleArrayQueue(6)
      var key = "" //接收用户的输入
      while (true) {
        println("请选择以下操作")
        println("show:显示队列 add：添加数据到队列  delete：删除元素 peek：查看队列头元素 q:退出")

        key = StdIn.readLine()
        key match {
          case "show" => queue.showQueue()
          case "add" =>
            println("请输入一个数")
            val value = StdIn.readInt()
            queue.addQueue(value)
          case "delete" =>
            val res = queue.deleteQueue()
            if (res.isInstanceOf[Exception]){
              //输出异常信息
              println(res.asInstanceOf[Exception].getMessage)
            }else{
              printf("删除的元素是%d\n",res)
            }
          case "peek" =>
            val res = queue.peek()
            //判断res的类型
            if(res.isInstanceOf[Exception]){
              //输出异常信息
              println(res.asInstanceOf[Exception].getMessage)
            }else{
              printf("队列的头元素是%d\n",res)
            }
          case "q" => return
        }
      }
    }
}
