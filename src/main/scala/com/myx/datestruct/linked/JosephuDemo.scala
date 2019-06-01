package com.myx.datestruct.linked

object JosephuDemo {
  def main(args: Array[String]): Unit = {
    val josephu = new Josephu()
    josephu.addBoy(5)
    josephu.list()
    josephu.countBoy(2,2,5)
    //josephu.countBoy1(2,2,5)
  }
}
