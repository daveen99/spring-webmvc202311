package com.spring.mvc.chap04.repository;

import com.spring.mvc.chap04.entity.Score;

import java.util.List;

/**
 * 역할: 성적정보를 저장하고 조회하고 수정하고 삭제하는 역할
 * 데이터베이스와 같은 저장소에 접근하는 객체 (Data Access Object - DAO)
 *
 * 왜 클래스로 안쓰고 인터페이스로 추상화를 하는지??
 * 실제로 저장소라는 개념은 구체적이지 않기 때문이다.
 * 파일로 저장, 인메모리 저장, 관계형 데이터베이스 저장, NOSQL... 다양하게 가능하다.
 */

public interface ScoreRepository {

    // 성적 정보 전체 목록 조회
    List<Score> findAll();
    List<Score> findAll(String sort);

    // 성적 정보 등록
    boolean save(Score score);

    // 성적 정보 삭제 - 1개 삭제
    boolean delete(int stuNum);

    // 성적 정보 개별 조회
    Score findOne(int stuNum);

    boolean update(int stuNum, int kor, int eng, int math);
}
