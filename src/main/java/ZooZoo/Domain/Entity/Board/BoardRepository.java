package ZooZoo.Domain.Entity.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

    //게시판 빼오기
    @Query(nativeQuery = true, value = "select * from board where cano = :categoryNumber")
    List<BoardEntity> findAllBoard(@Param("categoryNumber") int categoryNumber);

    //전체 댓글
    @Query(nativeQuery = true, value = "select * from board where apikey = :apikey and cano = :cano order by bno DESC")
    List<BoardEntity> findAllReply(@Param("apikey") String apikey, @Param("cano") int cano);


}