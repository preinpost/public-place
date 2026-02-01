package sk2022B;

import java.util.*;

public class B {

    static class Process implements Comparable<Process> {
        int command; // 0 : 읽기 , 1 : 쓰기
        int sTime;
        int eTime;
        int sIdx;
        int eIdx;
        int value;

        public Process(int command, int sTime, int eTime, int sIdx, int eIdx) {
            this.command = command;
            this.sTime = sTime;
            this.eTime = eTime;
            this.sIdx = sIdx;
            this.eIdx = eIdx;
        }

        public Process(int command, int sTime, int eTime, int sIdx, int eIdx, int value) {
            this.command = command;
            this.sTime = sTime;
            this.eTime = eTime;
            this.sIdx = sIdx;
            this.eIdx = eIdx;
            this.value = value;
        }

        @Override
        public int compareTo(Process o) {
            if (o.command == this.command) {
                return this.sTime - o.sTime;
            }
            return o.command - this.command;
        }
    }

    public String[] solution(String[] arr, String[] processes) {
        String[] answer = {};

        int currTime = 0;
        Queue<Process> processList = new LinkedList<>();
        Queue<Process> waitRoom = new PriorityQueue<>();
        Queue<Process> onProcess = new LinkedList<>();
        boolean readLock = false;
        boolean writeLock = false;

        for (String process : processes) {
            String[] split = process.split(" ");
            int command = split[0].equals("write") ? 1 : 0;
            int st = Integer.parseInt(split[1]);
            int et = Integer.parseInt(split[2]);
            int si = Integer.parseInt(split[3]);
            int ei = Integer.parseInt(split[4]);

            if (command == 1) {
                int val = Integer.parseInt(split[5]);
                processList.offer(new Process(command, st, et, si, ei, val));
            } else {
                processList.offer(new Process(command, st, et, si, ei));
            }
        }

        System.out.println();

        while (true) {

            // 작업중인 큐 체크
            if (!onProcess.isEmpty()) {
                int onProcessSize = onProcess.size();

                for (int i = 0; i < onProcessSize; i++) {
                    Process onProcessingProcess = onProcess.poll();

                    // 작업 끝나지 않은 경우
                    if (onProcessingProcess.eTime > currTime) {
                        onProcess.offer(onProcessingProcess);
                    }
                    // 작업 끝난 경우
                    else {

                        if (onProcessingProcess.command == 1) {
                            int sIdx = onProcessingProcess.sIdx;
                            int eIdx = onProcessingProcess.eIdx;

                            for (int j = sIdx; j <= eIdx; j++) {
                                arr[j] = String.valueOf(onProcessingProcess.value);
                            }

                            writeLock = false;
                        }
                        else {
                            int sIdx = onProcessingProcess.sIdx;
                            int eIdx = onProcessingProcess.eIdx;

                            for (int j = sIdx; j <= eIdx; j++) {
                                System.out.print(arr[j]);
                            }
                            System.out.println();
                            if (onProcess.size() == 0) readLock = false;
                        }
                    }
                }
            }

            // 대기 큐로 들어갈 프로세스 체크
            int listSize = processList.size();

            for (int i = 0; i < listSize; i++) {
                Process poll = processList.poll();
                if (poll.sTime <= currTime) {
                    waitRoom.offer(poll);
                } else {
                    processList.offer(poll);
                }
            }

            // 작업 큐로 들어갈 대기 큐 체크
            if (!waitRoom.isEmpty()) {
                int waitSize = waitRoom.size();

                for (int i = 0; i < waitSize; i++) {
                    Process waitProcess = waitRoom.poll();

                    if (!writeLock && !readLock && waitProcess.command == 1) {
                        waitProcess.eTime = currTime + waitProcess.eTime;
                        onProcess.offer(waitProcess);
                        writeLock = true;
                        break;
                    } else if (!writeLock && waitProcess.command == 0) {
                        waitProcess.eTime = currTime + waitProcess.eTime;
                        onProcess.offer(waitProcess);
                        readLock = true;
                    } else {
                        waitRoom.offer(waitProcess);
                    }
                }
            }

            currTime++;

            if (processList.isEmpty() && waitRoom.isEmpty() && onProcess.isEmpty()) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        B b = new B();

        String[] arr = new String[] {"1","2","4","3","3","4","1","5"};
        String[] processes = new String[] {
                "read 1 3 1 2",
                "read 2 6 4 7",
                "write 4 3 3 5 2",
                "read 5 2 2 5",
                "write 6 1 3 3 9",
                "read 9 1 0 7"};

//        String[] arr = new String[] {"1","1","1","1","1","1","1"};
//        String[] processes = new String[] {"write 1 12 1 5 8",
//                "read 2 3 0 2",
//                "read 5 5 1 2",
//                "read 7 5 2 5",
//                "write 13 4 0 1 3",
//                "write 19 3 3 5 5",
//                "read 30 4 0 6",
//                "read 32 3 1 5"};

        b.solution(arr, processes);
    }
}
