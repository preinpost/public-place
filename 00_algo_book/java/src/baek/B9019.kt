package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList


/**
 * DSLR
 */
fun main() {

    val bf = BufferedReader(InputStreamReader(System.`in`))
    val n = bf.readLine().toInt()
    val answer = StringBuffer()

    for (i in 0 until n) {
        val numbers = bf.readLine()

        val a = numbers.split(" ")[0].toInt()
        val b = numbers.split(" ")[1].toInt()

        val result = round(a, b)
        answer.append(result).append("\n")
    }
    println(answer)
}

fun round(number: Int, target: Int): String {
    val visited = Array(10001) {false}
    val Q = LinkedList<Pair<Int, String>>()

    Q.offer(Pair(number, ""))

    while (!Q.isEmpty()) {
        val poll = Q.poll()

        for (i in 0 until 4) {
            when (i) {
                0 -> {
                    val temp = funcD(poll.first)
                    if (visited[temp] == true) continue

                    if (temp != target) {
                        Q.offer(Pair(temp, poll.second + "D"))
                        visited[temp] = true
                    }
                    else return poll.second + "D"
                }
                1 -> {
                    val temp = funcS(poll.first)
                    if (visited[temp] == true) continue

                    if (temp != target) {
                        Q.offer(Pair(temp, poll.second + "S"))
                        visited[temp] = true
                    }
                    else return poll.second + "S"
                }
                2 -> {
                    val temp = funcL(poll.first)
                    if (visited[temp] == true) continue

                    if (temp != target) {
                        Q.offer(Pair(temp, poll.second + "L"))
                        visited[temp] = true
                    }

                    else return poll.second + "L"
                }
                3 -> {
                    val temp = funcR(poll.first)
                    if (visited[temp] == true) continue

                    if (temp != target) {
                        Q.offer(Pair(temp, poll.second + "R"))
                        visited[temp] = true
                    }
                    else return poll.second + "R"
                }
            }
        }
    }
    return ""
}


fun funcD(number: Int): Int {
    val result = number * 2

    if (result > 9999) {
        return result % 10000
    }

    return result
}

fun funcS(number: Int): Int {
    if (number == 0) return 9999
    return number - 1
}

fun funcL(number: Int): Int {
    return number % 1000 * 10 + number / 1000
}

fun funcR(number: Int): Int {
    return number % 10 * 1000 + number / 10
}