package org.example

var returnString = ""
var one = arrayOf('I', 'X', 'C', 'M')
var five = arrayOf('V', 'L', 'D')
var ten = arrayOf('X', 'C', 'M')
fun main() {
    println("Enter an Integer: ")
    val input: String = readln()
    println("Input is: $input")

    val places = input.length

/**
 * a more efficient way could be to keep track of which numbers are "special"
 * like 1 I, 5 V, 10 X, 50 L, 100 C, 1000M and have a set of rules based on the given number's relation
 * to these special numbers, since it is the same pattern for each place's special chars
 * ones place - I, V, X
 * tens place - X, L, C
 * hundreds place - C, D, M
**/

    //ensure String is now empty
    returnString = ""
    if (places > 3) {
        if (input.toInt() <= 3000){
            addToReturnString(input[0], Places.THOUSANDTHS)
            addToReturnString(input[1], Places.HUNDRETHS)
            addToReturnString(input[2], Places.TENS)
            addToReturnString(input[3], Places.ONES)
        }
    } else if (places == 3) {
        addToReturnString(input[0], Places.HUNDRETHS)
        addToReturnString(input[1], Places.TENS)
        addToReturnString(input[2], Places.ONES)
    } else if (places == 2) {
        addToReturnString(input[0], Places.TENS)
        addToReturnString(input[1], Places.ONES)
    } else {
        addToReturnString(input[0], Places.ONES)
    }

    println(returnString)
}

private fun addToReturnString(int: Char, places: Places) {
    val index: Int = places.int
    val one: Char = one[index]
    var fiveChar = ' '
    var tenChar = ' '
    if (places != Places.THOUSANDTHS) {
        fiveChar = five[index]
        tenChar = ten[index]
    }

    when (int) {
        '1' -> returnString += one
        '2' -> returnString = returnString + one + one
        '3' -> returnString = returnString + one + one + one
        '4' -> returnString = returnString + one + fiveChar
        '5' -> returnString += fiveChar
        '6' -> returnString = returnString + fiveChar + one
        '7' -> returnString = returnString + fiveChar + one + one
        '8' -> returnString = returnString + fiveChar + one + one + one
        '9' -> returnString = returnString + one + tenChar
    }
}