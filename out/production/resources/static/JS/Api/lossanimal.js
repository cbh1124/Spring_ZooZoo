function q1(){
    $.ajax({
        url: "/lossapi2",
        type : "get",
        data: {},
        success: function(response){

            let datalist = response["items"];
            for (let i = 0; i < datalist.length; i++) {
                let name = datalist[i]["age"];
                let inventory = datalist[i]["careAddr"];
                let tempHtml = `<tr>
                                    <td>${age}</td>
                                    <td>${careAddr}</td>
                                </tr>`
                $('#tname').append(tempHtml);
            }
        },
        error: function(){
            console.log("에러");
        }
    });
}

/*
function q1(){
    $.ajax({
        url: "/lossapi",
        type : "get",
        data: {},
        contentType : "application/json",
        dataType : "json",
        success: function(response){
            let datalist = response["data"];
            for (let i = 0; i < datalist.length; i++) {
                let name = datalist[i]["age"];
                let inventory = datalist[i]["careAddr"];
                let tempHtml = `<tr>
                                    <td>${age}</td>
                                    <td>${careAddr}</td>
                                </tr>`
                $('#tname').append(tempHtml);
            }

        },
        error: function(){
            console.log("에러");
        }
    });
}*/
