

var shopingList = [];


function Cart(selectMenu, selectSideMenu, samount, sPrice) {

    this.menu = selectMenu;
    this.side = selectSideMenu;
    this.amount = samount;
    this.price = sPrice;
}


var menuName=function(){

}


function createShoping() {

    var menu=$('#menu_info h2', this).html();
    var side=$('.btn_side h3', this).html();
    var amount=$('input[type=number]', this).html();
    var price=parseInt($('#select_count p'), this) + parseInt($('.btn_side p', this).html());

    shopingList.push(new Cart(menu, side, amount, price));

    cart_list();
    setLocal();

    return false;

}


function getSumPrice() {

}


function deleteCart(idx) {
    shopingList.splice(idx, 1);
    cart_list();
    setLocal();
}



function cart_list() {

    var list = '';
    list +='<table id="cart_list">';
    list += '<tr>';
    list += '<th>번호</th>';
    list += '<th>메뉴</th>';
    list += '<th>사이드</th>';
    list += '<th>수량</th>';
    list += '<th>금액</th>';
    list += '<th></th></tr>';
    

    for (var idx = 0; idx < shopingList.length; idx++) {
        list += '<tr>     <td>' + idx + '</td>';
        list += '     <td>' + shopingList[idx].menu + '</td>';
        list += '     <td>' + shopingList[idx].side + '</td>';
        list += '     <td> '+ shopingList[idx].amount +'</td>';
        list += '     <td>' + shopingList[idx].price + '</td>';
        list += '     <td> <a href="javascript:deleteCart('+idx+')">삭제</a> </td></tr>';
    }   
    list+='</table>';

    $('#cart_list').html(list);
}



function initStore() {

    var data = localStorage.getItem('foodcart');
    if (data == null) {
        var jdata = JSON.stringify(shopingList);
        localStorage.setItem('foodcart', jdata);
    } else {
        shopingList = JSON.parse(data);
    }

}



//로컬저장소에 저장
function setLocal() {
    var jsondata = JSON.stringify(shopingList);
    localStorage.setItem('foodcart', jsondata);
}

$(document).ready(function () {

    initStore();
    cart_list();
    $('#side_ok').submit(createShoping);

});


