package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/**
 * 설탕 배달
 */
fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()

    val bags = listOf(5, 3)

    val dp = IntArray(5001, { _ -> Int.MAX_VALUE} )


    for (bag in bags) {
        dp[bag] = 1
    }

    for (i in 6..5000) {
        if (dp[i - 3] == Int.MAX_VALUE && dp[i - 5] == Int.MAX_VALUE) continue
        dp[i] = min(dp[i - 3], dp[i - 5]) + 1
    }

    println(if (dp[n] == Int.MAX_VALUE) -1 else dp[n])
}