package baek

import java.io.BufferedReader
import java.io.InputStreamReader


class State(
    val a: Int,
    val b: Int,
    val c: String
)

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val n = bf.readLine().toInt()

    val stateArray = ArrayList<State>()

    for (i in 0 until n) {
        val entity = bf.readLine().split(" ")
        val age = entity[0].toInt()
        val name = entity[1]

        stateArray.add(State(a = age, b = i, c = name))
    }

    stateArray.sortWith(compareBy<State> { it.a }.thenBy { it.b })

    for (e in stateArray) {
        println("${e.a} ${e.c}")
    }
}

