package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.sqrt

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val s = bf.readLine()
    val st = StringTokenizer(s)

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val arr = BooleanArray(n+1)
    arr[0] = true
    arr[1] = true

    for (i: Int in 2..sqrt(n.toDouble()).toInt()) {

        if (!arr[i]) {
            for (j in i*i..n step i) {
                arr[j] = true
            }
        }
    }

    for (i in m..n) {
        if (!arr[i]) print("$i ")
    }
}