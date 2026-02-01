package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val answer = StringBuilder()
    val bf = BufferedReader(InputStreamReader(System.`in`))

    while (true) {

        val line = bf.readLine().split(" ")

        val b = line[0].toInt()
        val g = line[1].toInt()

        if (b == 0 && g == 0) {
            break
        }

        answer.append(b + g).append("\n")
    }

    println(answer)
}