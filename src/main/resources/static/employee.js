function deleteBtn(empId){

    $.ajax({
        type:"DELETE",
        url:"/emp/delete?empId="+empId,
        success:function(result){
            location.reload(true);
        },
        error:function(result){
            alert(result);
        }
    });

}