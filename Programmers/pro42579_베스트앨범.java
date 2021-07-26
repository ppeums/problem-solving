import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Genre> genreQ = new PriorityQueue<>();
        int len = plays.length;
        for (int i = 0; i < len; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        for (String key : map.keySet()) {
            genreQ.add(new Genre(key, map.get(key)));
        }
        while (!genreQ.isEmpty()) {
            PriorityQueue<Song> songQ = new PriorityQueue<>();
            Genre genre = genreQ.poll();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (genres[i].equals(genre.name)) {
                    songQ.add(new Song(i, plays[i]));
                    cnt++;
                }
            }
            int genreCnt = 0;
            if (cnt == 1) {
                genreCnt = 1;
            } else {
                genreCnt = 2;
            }
            while (genreCnt > 0) {
                answer.add(songQ.poll().id);
                genreCnt--;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Genre implements Comparable<Genre> {
        String name;
        int playSum;

        public Genre(String name, int playSum) {
            this.name = name;
            this.playSum = playSum;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.playSum, this.playSum);
        }
    }

    class Song implements Comparable<Song> {
        int id, play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if (this.play != o.play) {
                return Integer.compare(o.play, this.play);
            } else {
                return Integer.compare(this.id, o.id);
            }
        }
    }
}