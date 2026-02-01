package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val line = bf.readLine()

    val split = line.split(" ")
    val largest = max(split[0].length, split[1].length)

    val aArray = split[0].padStart(largest, '0').toCharArray()
    val bArray = split[1].padStart(largest, '0').toCharArray()
    val answer = StringBuilder()

    var ptr = largest - 1
    var carry = 0

    while (ptr >= 0) {
        val numA= aArray[ptr].code - '0'.code
        val numB = bArray[ptr].code - '0'.code

        val sum = numA + numB + carry
        val digit = sum % 10
        carry = sum / 10

        answer.append(digit.toChar() + '0'.code)

        ptr -= 1
    }

    if (carry > 0) {
        answer.append(carry)
    }

    answer.reverse()

    println(answer)
}