##### [Simple Method](SimpleAlgorithm.java)
有一个文本串S，和一个模式串P<br>
如果用暴力匹配的思路，并假设现在文本串S匹配到 i 位置，模式串P匹配到 j 位置，则有：<br>
* 如果当前字符匹配成功（即S[i] == P[j]），则i++，j++，继续匹配下一个字符；
* 如果失配（即S[i]! = P[j]），令i = i - j + 1，j = 0。相当于每次匹配失败时，i 回溯，j 被置为0。

##### [KMP Method](KMPAlgorithm.java)
采用KMP算法，推荐博客：[从头到尾彻底理解KMP](https://blog.csdn.net/v_july_v/article/details/7041827) 
