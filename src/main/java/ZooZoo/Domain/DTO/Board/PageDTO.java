package ZooZoo.Domain.DTO.Board;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {

    private int page;           // 현재 페이지 번호
    private int startPage;      // 각 페이지리스트 시작페이지 번호
    private int endPage;        // 각 페이지리스트 끝페이지 번호
    private int realEnd;        // 게시판 최종 마지막 페이지 번호

    private int totalPageCnt;        // 전체 페이지 수
    private int cntPerPage = 10;  // 페이지 당 게시물 개수
    private int listSize = 10; // 페이지 리스트의 페이지 개수 (몇페이지까지 버튼 만들거인지)
    private int range;          // 각 페이지 범위 시작 번호
    private int totalCnt;        // 전체 게시물 개수


    private int startList;      // 게시판 시작번호

    private boolean prev;       // 이전 페이지 여부
    private boolean next;       // 다음 페이지 여부

    public void pageInfo(int page, int totalCnt) {

        this.page = page; // 현재 페이지
        this.totalCnt = totalCnt; // 전체 게시물 수

        // 전체 페이지 수 = 전체 게시물 개수 / 한페이지 게시물 개수 (소수점일경우 올림)
        this.totalPageCnt = (int) Math.ceil(totalCnt / cntPerPage);
        // 페이지 시작 번호 (1, 11, 21 ....)
        this.startPage = (int) Math.ceil(page / cntPerPage - 1) * listSize + 1;
        // 페이지 끝 번호 (10, 20, 30 ....)
        if ((int) Math.ceil(page / listSize) * listSize > this.totalPageCnt) {
            this.endPage = this.totalPageCnt;
        }


    }
}
