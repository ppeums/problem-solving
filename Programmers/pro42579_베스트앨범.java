import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        int genreCnt = 0;
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], genreCnt);
                genreCnt++;
            }
        }
        ArrayList<Music>[] musicList = new ArrayList[genreCnt];
        Genre[] sumList = new Genre[genreCnt];
        for (int i = 0; i < genreCnt; i++) {
            musicList[i] = new ArrayList<>();
            sumList[i] = new Genre(i, 0);
        }
        for (int i = 0; i < genres.length; i++) {
            int genreId = map.get(genres[i]);
            musicList[genreId].add(new Music(i, genres[i], plays[i]));
            sumList[genreId] = new Genre(genreId, sumList[genreId].playSum + plays[i]);
        }
        int answerCnt = 0;
        for (int i = 0; i < musicList.length; i++) {
            if (musicList[i].size() > 1) {
                answerCnt += 2;
            } else {
                answerCnt++;
            }
        }
        int[] answer = new int[answerCnt];
        Arrays.sort(sumList, new Comparator<Genre>() {
            @Override
            public int compare(Genre o1, Genre o2) {
                return Integer.compare(o2.playSum, o1.playSum);
            }
        });
        int idx = 0;
        for (int i = 0; i < musicList.length; i++) {
            int genreId = sumList[i].id;
            Collections.sort(musicList[genreId], new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    return Integer.compare(o2.play, o1.play);
                }
            });
            answer[idx++] = musicList[genreId].get(0).id;
            if (musicList[genreId].size() > 1) {
                answer[idx++] = musicList[genreId].get(1).id;
            }
        }
        return answer;
    }

    static class Genre {
        int id, playSum;

        public Genre(int id, int playSum) {
            this.id = id;
            this.playSum = playSum;
        }
    }

    static class Music {
        int id, play;
        String genre;

        public Music(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }
    }
}