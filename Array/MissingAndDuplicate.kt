package Array

fun main(args:Array<String>){
    val arr = arrayOf(1,2,4,4,5)
    findMissingAndDuplicate(arr)
}

private fun findMissingAndDuplicate(arr:Array<Int>){
    val size = arr.size;
    val sumOfArr = (size)*(size+1)/2
    var givenSum = 0
    var givenSqauredSum = 0
    for(i in arr){
        givenSum += i
        givenSqauredSum += (i*i)
    }

    //a+b+c+d+e
    //a+b+b+d+e
    //c-b = diff
    val diff = sumOfArr - givenSum;

    //c^2 - b^2 = (c+b)* (c-b) = sqDiff
    var calculatedSqSum = 0

    for(i in 1..size){
        calculatedSqSum += (i*i)
    }
    println(calculatedSqSum)

    val sqDiff = calculatedSqSum - givenSqauredSum
    val missing  = ((sqDiff/diff) + diff)/2
    println("Missing $missing")
    println("Repeated ${missing-diff}")
}