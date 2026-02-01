package baek

import java.io.BufferedReader
import java.io.InputStreamReader

var min = Integer.MAX_VALUE

/**
 * 리모컨
 */
fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    var n = bf.readLine().toInt()
    val m = bf.readLine().toInt()

    // Case 02
    if (n == 100) {
        println(0)
        return
    }

    // Case 01
    if (m == 0) {
        min = Math.min(min, n.toString().length)
        min = Math.min(min, Math.abs(100 - n))

        println(min)
        return
    }


    // Case 03
    min = Math.min(min, Math.abs(100 - n))

    val candid = mutableListOf<Int>()

    val numbers = bf.readLine().split(" ")

    for (i in 0 until 10) {
        if (!numbers.contains(i.toString())) candid.add(i)
    }

    /**
     * 1. 고장난 버튼이 없는 경우
     * 2. target이 100번인 경우
     * 3. +나 - 누를 때 더 빠른경우
     * 4. 모든버튼 눌러본 경우
     */

    for (i in 1..6) {
        dupCombination(0, i, IntArray(i), candid, n)
    }

    println(min)
}

fun dupCombination(depth: Int, digit: Int, arr: IntArray, candid: MutableList<Int>, target: Int) {
    if (depth == digit) {
        var num = 0
        var length = arr.size - 1

        for (i in arr.indices) {
            num += arr[i] * (Math.pow(10.0, length.toDouble())).toInt()
            length--
        }

        val btnCount = digit + Math.abs(target - num)
        min = Math.min(min, btnCount)

        return
    }

    for (i in candid) {
        arr[depth] = i
        dupCombination(depth+1, digit, arr, candid, target)
    }
}