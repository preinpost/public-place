package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))

    val n = bf.readLine().toInt()
    val line = bf.readLine().split(" ").map(String::toInt)

    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = 1
        val current = line[i]
        for (j in 0 until i) {
            if (current > line[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    var max = Int.MIN_VALUE
    for (i in 0 until n) {
        max = max(max, dp[i])
    }
    println(max)
}