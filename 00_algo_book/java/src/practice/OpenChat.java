package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {

    enum Message {
        Enter("님이 들어왔습니다."),
        Leave("님이 나갔습니다.");

        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum Command {
        Enter,
        Leave,
        Change
    }

    public static void main(String[] args) {
//        String[] record = {"Enter uid1234 Muzi", "Change uid1234 TTT","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 123123","Change uid4567 Ryan", "Leave uid4567"};
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

        // change가 있으면, 닉네임 변경 로직 실행

        Map<String, String> nickMap = new HashMap<>();

        for (String s : record) {
            String[] split = s.split("\\s+");
            String command, id, nickname = "";

            command = split[0];
            id = split[1];

            if (!command.equals("Leave")) {
                nickname = split[2];
            }

            if (command.equals(Command.Enter.toString())) {
                if(nickMap.get(id) != null) nickMap.put(id, nickname);
            }

            if (nickMap.get(id) == null || command.equals(Command.Change.toString())) {
                nickMap.put(id, nickname);
            }
        }

        String[] answer = makeMessage(record, nickMap);

        for (String s : answer) {
            System.out.println("s = " + s);
        }

    }

    static String[] makeMessage(String[] record, Map<String, String> nickMap) {
        List<String> newMessage = new ArrayList<>();


        for (String s : record) {
            StringBuffer sb = new StringBuffer();

            // find nickname
            String[] split = s.split("\\s+");
            String command = split[0];
            String id = split[1];
            String getNickname = nickMap.get(id);


            sb.append(getNickname);

            // find Command
            for (Command comm : Command.values()) {
                String commValue = comm.toString();

                if (commValue.equals(Command.Change.toString())) break;

                if(command.equals(commValue)) {
                    sb.append(Message.valueOf(commValue).getValue());

                    newMessage.add(sb.toString());
                    break;
                }
            }

        }
        return newMessage.toArray(new String[0]);
    }
}
