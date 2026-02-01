package programmers.book.P14;

// P14. 신규 아이디 추천
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        new_id = new_id.replaceAll("[.]+", ".");
        new_id = new_id.replaceAll("^[.]+|[.]+$", "");

        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]+$", "");
        }

        if (new_id.length() < 3) {
            String last = new_id.substring(new_id.length() - 1, new_id.length());
            int cnt = 3 - new_id.length();

            for (int i = 0; i < cnt; i++) {
                new_id += last;
            }
        }

        System.out.println(new_id);

        return new_id;
    }
}
