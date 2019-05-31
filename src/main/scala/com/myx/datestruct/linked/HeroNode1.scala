package com.myx.datestruct.linked

class HeroNode1(hNo:Int,hName:String,hNickname:String) {
  val no = hNo
  var name = hName
  var nickname = hNickname
  var next:HeroNode1 = null
  var pre:HeroNode1 = null
}
