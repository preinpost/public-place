package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val n = bf.readLine().toInt()
    val answer = StringBuilder()

    for (i in 0 until n) {
        val line = bf.readLine().split(" ")
        val a = line[0].toInt()
        val b = line[1].toInt()
        answer.append("Case #%d: %d + %d = %d".format(i + 1, a, b, a + b))
        answer.append("\n")
    }

    println(answer)
}