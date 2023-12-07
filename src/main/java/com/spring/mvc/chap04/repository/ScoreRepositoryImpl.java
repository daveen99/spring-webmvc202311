package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

@Repository("mRepo")
public class ScoreRepositoryImpl implements ScoreRepository{

    // 인메모리 저장공간 (해시맵)
    // Key: 학번, Value: 성적정보
    private static final Map<Integer, Score> scoreMap;

    // 학번을 생성할 일련번호
    private static int seq;

    // 객체 초기화는 직접하는것보다 주입받거나 생성자를 통해 처리하는게 좋다.
    // 스태틱 이니셜라이즈
    static {
        scoreMap = new HashMap<>();
        Score s1 = new Score("김흥국", 100, 88, 33, ++seq, 0, 77.0, Grade.F);
        Score s2 = new Score("보이비", 33, 99, 11, ++seq, 0, 44.0, Grade.D);
        Score s3 = new Score("바비", 66, 55, 22, ++seq, 0, 66.0, Grade.B);

        scoreMap.put(s1.getStuNum(), s1);
        scoreMap.put(s2.getStuNum(), s2);
        scoreMap.put(s3.getStuNum(), s3);
    }

    @Override
    public List<Score> findAll() {
        // Map에 있는 모든 성적정보를 꺼내서 리스트에 담아라
//        List<Score> temp = new ArrayList<>();
//        for (Integer key : scoreMap.keySet()) {
//            Score score = scoreMap.get(key);
//            temp.add(score);
//        }

        return new ArrayList<>(scoreMap.values())
                .stream()
                .sorted(comparing(Score::getStuNum))
                .collect(toList())
                ;
    }

    @Override
    public List<Score> findAll(String sort) {

        Comparator<Score> comparing = comparing(Score::getStuNum);

        switch (sort) {
            case "num":
                comparing = comparing(Score::getStuNum);
                break;
            case "name":
                comparing = comparing(Score::getName);
                break;
            case "avg":
                comparing = comparing(Score::getAverage);
                break;
        }
        return scoreMap.values().stream()
                .sorted(comparing)
                .collect(toList())
                ;
    }

    @Override
    public boolean save(Score score) {
        // 학번 넣어주기
        score.setStuNum(++seq);

        // 중복된 학번을 입력하면 저장실패
        if (scoreMap.containsKey(score.getStuNum()))
            return false;

        scoreMap.put(score.getStuNum(), score);
        return true;
    }

    @Override
    public boolean delete(int stuNum) {
        // 없는 학번을 전달받을 경우는 삭제실패
        if (!scoreMap.containsKey(stuNum))
            return false;

        scoreMap.remove(stuNum);
        return true;
    }

    @Override
    public Score findOne(int stuNum) {
        return scoreMap.get(stuNum);
    }

    @Override
    public boolean update(int stuNum, int kor, int eng, int math) {
        if (!scoreMap.containsKey(stuNum))
            return false;

        Score score = scoreMap.get(stuNum);

        score.setKor(kor);
        score.setEng(eng);
        score.setMath(math);

        return true;
    }
}
