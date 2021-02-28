/**
 * 获取id拼接
 * @param data
 */
function getCheckId(data){
    var arr= new  Array();
    for(var i=0;i<data.length;i++){
        arr.push(data[i].id);
    }
    //拼接id
    return arr.join(",");
}

