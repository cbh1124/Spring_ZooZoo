//
//    var data = {
//        "b_no": "0000000000" // 사업자번호 "xxxxxxx" 로 조회 시,
//       };
//
//    $.ajax({
//      url: "https://api.odcloud.kr/api/nts-businessman/v1/validate?serviceKey=hm1u3zRV0ba96YTa5BqV4zu0jYFV2LGfPe2aRk0NyJVQsoX5FCSjuVth8RKvBvQzOW8ApIHwaxmajW9%2FRaYR5A%3D%3D",  // serviceKey 값을 xxxxxx에 입력
//      type: "POST",
//      data: JSON.stringify(data), // json 을 string으로 변환하여 전송
//      dataType: "JSON",
//      contentType: "application/json",
//      accept: "application/json",
//      success: function(result) {
//          console.log(result);
//      },
//      error: function(result) {
//          console.log(result.responseText); //responseText의 에러메세지 확인
//      }
//    });

function q1(){
alert("ok");
    $.ajax({
        url: "/test",
        type : "POST",
        data: {},
        contentType : "application/json",
        dataType : "json",
        success: function(response){
            let datalist = response["businesses"];
            for (let i = 0; i < datalist.length; i++) {
                let b_no = datalist[i]["b_no"];
                let b_nm = datalist[i]["b_nm"];
                let tempHtml = `<tr>
                                    <td>${b_no}</td>
                                    <td>${b_nm}</td>
                                </tr>`
                $('#tname').append(tempHtml);

        },
        error: function(){
            console.log("에러");
        }
    });

}
