package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    // 킹(1), 퀸(1), 룩(2), 비숍(2), 나이트(2), 폰(8)
    // 0 1 2 2 2 7

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val line = bf.readLine()
    val split = line.split(" ").map { it.toInt() }

    val arr = intArrayOf(1, 1, 2, 2, 2, 8)
    val answer = StringBuffer()

    for (i in 0..5) {
        answer.append(arr[i] - split[i])
        answer.append(" ")
    }

    println(answer)
}