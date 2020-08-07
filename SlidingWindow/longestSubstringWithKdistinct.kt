package SlidingWindow

fun main(args : Array<String>){
    val str = "pqrstabbbacdea"
    findLongest(str, 2)
}

private fun findLongest(str : String, k:Int){
    val map = HashMap<Char, Int>()
    var start = 0
    var maxLen = 0
    for(end in 0..str.length-1){
        var item = str[end]
        if(map.containsKey(item)){
            map.put(item, map.get(item)!!.plus(1))
        }else{
            map.put(item, 1)
        }
        while(map.size>k){
            val rem = str[start]
            map.put(rem, map.get(rem)!!.minus(1))
            if(map.get(rem)==0){
                map.remove(rem)
            }
            start++
        }
        maxLen = Math.max(maxLen, end-start+1)
    }

    println("Max length of characters with k distinct characters is: $maxLen")
}