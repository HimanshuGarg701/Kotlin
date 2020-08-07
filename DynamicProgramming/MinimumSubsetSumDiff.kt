package DynamicProgramming

fun main(args : Array<String>){
    val array = arrayOf(1,2,7)
    var sum = 0
    for(i in array){
        sum += i
    }

    val matrix = Array(array.size+1){Array(sum+1){false} }

    fillMatrix(array, sum, matrix)
    println("The minimum difference is ${findDiff(matrix, array, sum)}")
}

private fun fillMatrix(array:Array<Int>, sum : Int, matrix:Array<Array<Boolean>>){
    for(i in 0..array.size){
        matrix[i][0] = true
    }

    for(i in 1..array.size){
        for(j in 1..sum){
            if(array[i-1]<=j){
                matrix[i][j] = matrix[i-1][j-array[i-1]] || matrix[i-1][j]
            }else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }
}

private fun findDiff(matrix:Array<Array<Boolean>>, array : Array<Int>, sum:Int) : Int{
    val size = array.size
    val last = matrix[size]
    val list = ArrayList<Int>()
    for(i in 0..(last.size)/2){
        if(last[i]){
            list.add(i)
        }
    }
    for(i in list){
        println(i)
    }
    return Math.abs(sum - 2*list.get(list.size-1))

}