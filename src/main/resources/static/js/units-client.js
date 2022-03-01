$(document).ready(function(){
    getProducts(); 

});
 

function getProducts(){
    $.ajax({
        type: "GET",
        url: "/units",
        success: function(response){
            var i = 1; 
            response.forEach(function(data){
                var id = data.id;
                $("#unit-list").append(
                    "<tr>" +
                    "<td>" +
                    i + 
                    "<td>" +
                    data.icon +
                    "</td>" + 
                    "<td>" +
                   "<a href='/unit?id="+data.code+"'>" +data.name+"</a>"+
                    "</td>" +
                    "</tr>"
            );
                i++;
            });
        },
        error: function(xhr, status, error){
            var statusCode = xhr.status;
            console.log("Status code : " + statusCode);
            if (statusCode === 404){
                $("#unit-list").append(
                    "<tr>" +
                    "<td colspan='5' align='center'>Data kosong</td>" +
                    "</tr>"
                );
            }
        }
    });
}
 