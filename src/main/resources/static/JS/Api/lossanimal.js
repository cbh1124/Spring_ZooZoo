$(function(){
    $.ajax({
        url: "/lossapi",
        type : "get",
        data: {},
        contentType : "application/json",
        dataType : "json",
        success: function(response){
            let datalist = response["data"];
            for (let i = 0; i < datalist.length; i++) {
                let name = datalist[i]["name"];
                let inventory = datalist[i]["inventory"];
                let price = datalist[i]["price"];
                let tel = datalist[i]["tel"];
                let tempHtml = `<tr>
                                    <td>${name}</td>
                                    <td>${inventory}</td>
                                    <td>${price}</td>
                                    <td>${tel}</td>
                                </tr>`
                $('#tname').append(tempHtml);
            }

        },
        error: function(){
            console.log("에러");
        }
    });
}