package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))

    val n = bf.readLine().toInt()
    val Q = LinkedList<Int>()

    for (i in 1..n) {
        Q.offer(i)
    }


    while (Q.size > 1) {
        Q.poll()
        Q.offer(Q.poll())
    }

    println(Q.poll())
}