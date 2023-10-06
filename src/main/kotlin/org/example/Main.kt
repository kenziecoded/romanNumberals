package org.example

var returnString = ""
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
    if (places > 2) {
        if (input == "100") {
            returnString = "C"
        } else {
            returnString = ""
        }
    } else if (places == 2) {
        when (input[0]) {
            '1' -> returnString += "X"
            '2' -> returnString += "XX"
            '3' -> returnString += "XXX"
            '4' -> returnString += "XL"
            '5' -> returnString += "L"
            '6' -> returnString += "LX"
            '7' -> returnString += "LXX"
            '8' -> returnString += "LXXX"
            '9' -> returnString += "XC"
        }
        getSingleNum(input[1])
    } else {
        getSingleNum(input[0])
    }

    println(returnString)
}

fun getSingleNum(int: Char) {
    when (int) {
        '1' -> returnString += "I"
        '2' -> returnString += "II"
        '3' -> returnString += "III"
        '4' -> returnString += "IV"
        '5' -> returnString += "V"
        '6' -> returnString += "VI"
        '7' -> returnString += "VII"
        '8' -> returnString += "VIII"
        '9' -> returnString += "IX"
    }
}