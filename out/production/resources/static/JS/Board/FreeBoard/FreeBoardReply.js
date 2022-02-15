//댓글 쓰기
function freeReplyWrite(bno){
    var frcontents = $("#frcontents").val();
    $.ajax({
        url:"/Board/Free/FreeBoardReplyWrite",
        data:{"bno":bno, "frcontents":frcontents},
        success: function(result) {
           if(result ==1){
               alert("로그인이 필요합니다.")
               location.href = "/Member/Login";
           }else if(result == 2){
               alert("내용을 입력해주세요.");
           }else if(result == 3){
               alert("댓글 등록 완료");
               location.reload();
           }else {
               alert("버그 발생!!");
           }
        }
    });
}

//자유게시판 댓글 삭제
function freeReplyDelete(rno){
    alert(rno);
    $.ajax({
        url:"/Board/Free/FreeBoardReplyDelete",
        data:{"rno":rno},
        success: function(result) {
            if(result == 1){
                alert("댓글 삭제 완료");
                 $("#freeReplytable").load(location.href + ' #freeReplytable');
            }else{
                alert("댓글 삭제 실패");
            }
        }
    });
}

//자유게시판 댓글 수정
function freeReplyUpdate(rno){
    document.getElementById("fRNewContentsBox"+rno).innerHTML = "<input class='form-control' type='text' id='newFRContents' name='newFRContents'>";
    document.getElementById("btnFRupdate"+rno).style = "display:none"; // 수정버튼 감추기
    document.getElementById("btnFRchange"+rno).style = "display:block"; // 확인버튼 보이기
        alert("확인4" + rno);

    $(function(){
        $("#btnFRchange"+rno).click(function(){ // 확인 버튼 클릭
            $.ajax({
                url: "/replyupdate",
                data: {"rno" : rno, "newcontents" : document.getElementById("newFRContents").value},
                success : function(result){
                    alert(rno)
//                    if(result == 1){
//                            alert(rno);
////                        document.getElementById("tdbcontents"+bno).innerHTML = document.getElementById("newcontents").value;
////                        document.getElementById("btnrchange"+bno).style = "display:none"; // 확인버튼 감추기
////                        document.getElementById("btnrupdate"+bno).style = "display:block"; // 수정버튼 보이기
//                    } else {
//                        alert("오류발생");
//                    }
                }
            });
        });
    });
}

function rupdate(bno){

    document.getElementById("tdbcontents"+bno).innerHTML = "<input class='form-control' type='text' id='newcontents' name='newcontents'>";
    document.getElementById("btnrupdate"+bno).style = "display:none"; // 수정버튼 감추기
    document.getElementById("btnrchange"+bno).style = "display:block"; // 확인버튼 보이기
    $("#btnrchange"+bno).click(function(){ // 확인 버튼 클릭
        $.ajax({
            url: "/replyupdatea",
            data: {"bno" : bno, "newcontents" : document.getElementById("newcontents").value},
            success : function(result){
                if(result == 1){
                    document.getElementById("tdbcontents"+bno).innerHTML = document.getElementById("newcontents").value;
                    document.getElementById("btnrchange"+bno).style = "display:none"; // 확인버튼 감추기
                    document.getElementById("btnrupdate"+bno).style = "display:block"; // 수정버튼 보이기
                } else {
                    alert("오류발생");
                }
            }
        });
    });


}