//아이디 찾기
function findid(){
    var mname = $("#mname").val();
    var memail = $("#memail").val();
    $.ajax({
        url:"/Member/FindIdController",
        method: "post",
        data:{"mname":mname, "memail":memail},
        success: function(result) {
            //1이면 공백값이라 공백막기
            //alert(result);
           if(result == 1){
                $("#findidmsg").html("내용을 입력해주세요.");
                $("#findidmsg").css({"color":"#ff7f50","font-size":"1.0em"});
            }else if(result == 2){
                $("#findidmsg").html("동일한 회원 정보가 없습니다.");
                $("#findidmsg").css({"color":"#ff7f50","font-size":"1.0em"});
            }else{
                $("#findidmsg").html("회원님의 아이디는 "+result+"입니다.");
                $("#findidmsg").css({"color":"#ff7f50","font-size":"1.0em"});
            }
        }
    });
}

// 회원탈퇴
function mdelete(){
    var passwordconfirm = document.getElementById("passwordconfirm").value;

    $.ajax({
        url: "/Member/mdelete",
        data:{"passwordconfirm" : passwordconfirm},
        success: function(result){
            if (result == 1){
                location.href = "/Member/Logout"
            } else {
                $("#deletemsg").html("비밀번호가 일치하지 않습니다.");
            }
        }
    });
}

// 회원수정

function mupdate(mno){
    document.getElementById("tdmname").style = "display:none"
    document.getElementById("newmname").style = "display:block"
}