package DynamicProgramming

fun main(args : Array<String>){
    val array = arrayOf(1,2,3)
    val diff = 4
    var sum = 0

    for(i in array){
        sum += i
    }

    //s1+s2=sum
    //s1-s2=diff
    //2s1 = sum+diff
    //s1 = (sum+diff)/2
    //count number of s1

    val s1 = (sum-diff)/2
    countOccurrences(array, s1)
}

private fun countOccurrences(array:Array<Int>, sum:Int){
    val matrix = Array(array.size+1){Array(sum+1){0} }
    for(i in 0..array.size){
        matrix[i][0] = 1
    }

    for(i in 1..array.size){
        for(j in 1..sum){
            if(array[i-1]<=j){
                matrix[i][j] = matrix[i-1][j-array[i-1]] + matrix[i-1][j]
            }
            else{
                matrix[i][j] = matrix[i-1][j]
            }
        }
    }

    println("The number of times diff can form : ${matrix[array.size][sum]}")
}