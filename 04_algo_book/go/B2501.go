package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {

	reader := bufio.NewReader(os.Stdin)
	line, _, _ := reader.ReadLine()

	s := string(line)
	split := strings.Split(s, " ")

	n, _ := strconv.Atoi(split[0])
	k, _ := strconv.Atoi(split[1])

	var candidList []int

	for i := 1; i <= n; i++ {
		if n%i == 0 {
			candidList = append(candidList, i)
		}
	}

	if len(candidList) < k {
		fmt.Println(0)
	} else {
		fmt.Println(candidList[k-1])
	}
}
