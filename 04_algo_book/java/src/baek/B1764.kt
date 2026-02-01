package baek

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val readline = bf.readLine().split(" ")
    val n = readline[0].toInt()
    val m = readline[1].toInt()

    val hSet = HashSet<String>()
    val answer = ArrayList<String>()

    for (i in 0 until n) {
        val line = bf.readLine()
        hSet.add(line)
    }

    for (i in 0 until m) {
        val line = bf.readLine()
        if (hSet.contains(line)) {
            answer.add(line)
        }
    }

    println(answer.size)
    answer.sort()
    for (s in answer) {
        println(s)
    }
}