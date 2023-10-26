package edu.kh.project.board.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO : 데이터 전달용 객체
// - 클래스간의 이동(레이어 이동) 시
//   필요한 데이터를 한 번에 담아 전달하는 용도의 객체

// DTO 사용시 많이 하는 실수
// -> 담아야하는 데이터가 있으면 필요한 만큼, 필요한 형태로 필드 작성

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Board {
	// BOARD 테이블과 매핑되는 필드
	
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private String boardWriteDate;
    private String boardUpdateDate;
    private int readCount;
    private String boardDelFl;
    private int memberNo;
    private int boardCode;
    
    // 목록 조회, 상세조회 시 매핑되는 필드
    private int commentCount; // 댓글 수
    private int likeCount; // 좋아요 수
    private String memberNickname; // 작성자 닉네임
    private String thumnail; // 썸네일 이미지 경로
}
