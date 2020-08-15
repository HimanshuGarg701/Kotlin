package Recursion

import java.util.*

fun main(args:Array<String>){
    val stack = Stack<Int>()
    stack.add(1)
    stack.add(2)
    stack.add(3)
    stack.add(4)
    stack.add(5)

    val toRemove = stack.size/2
    removeElement(stack, toRemove)

    while(!stack.isEmpty()){
        println("  ${stack.pop()}  ")
    }
}

private fun removeElement(stack: Stack<Int>, toRemove:Int){
    if(toRemove==0){
        stack.pop()
        return
    }else{
        val rem = stack.peek()
        stack.pop()
        removeElement(stack, toRemove-1)
        stack.add(rem)
    }
}