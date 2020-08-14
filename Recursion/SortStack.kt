package Recursion

import java.util.*

fun main(args:Array<String>){
    val stack = Stack<Int>()
    stack.add(2)
    stack.add(1)
    stack.add(4)
    stack.add(5)
    stack.add(3)
    sortStack(stack)

    while(!stack.isEmpty()){
        print("  ${stack.pop()}  ")
    }
}

private fun sortStack(stack:Stack<Int>){
    if(stack.size==0 || stack.size==1){
        return
    }else{
        val rem = stack.peek()
        stack.pop()
        sortStack(stack)
        insert(stack, rem)
    }
}

private fun insert(stack:Stack<Int>, toAdd:Int){
    if(stack.size==0 || stack.peek()<=toAdd){
        stack.add(toAdd)
        return
    }
    else{
        val rem = stack.peek()
        stack.pop()
        insert(stack, toAdd)
        stack.add(rem)
    }
}