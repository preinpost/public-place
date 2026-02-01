package baek

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))

    val n = bf.readLine().toInt()
    val answer = StringBuffer()

    for (i in 0 until n) {

        val priorityQueue = PriorityQueue {a: Pair<Int, Int>, b: Pair<Int, Int> -> b.second - a.second}
        val queue = LinkedList<Pair<Int, Int>>()
        var readLine = bf.readLine()
        var st = StringTokenizer(readLine)

        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        readLine = bf.readLine()
        st = StringTokenizer(readLine)

        for (j in 0 until n) {
            val next = st.nextToken().toInt()

            queue.add(Pair(j, next))
            priorityQueue.add(Pair(j, next))
        }

        var cnt = 0
        while (!queue.isEmpty()) {

            if (queue.peek().second != priorityQueue.peek().second) {
                queue.offer(queue.poll())
            } else {
                val poll = queue.poll()
                priorityQueue.poll()
                cnt++

                if (poll.first == m) {
                    answer.append(cnt).append("\n")
                    break
                }
            }
        }
    }

    println(answer)
}