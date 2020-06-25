
window.onload = function () {


    // Get the modal
    var modal = document.getElementById('myModal');
  
    // Get the button that opens the modal
    var wrap01 = document.getElementById('wrap01');
    var wrap02 = document.getElementById('wrap02');
    var wrap03 = document.getElementById('wrap03');
  
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName('close')[0];
  
    // When the user clicks on the button, open the modal 
    setTimeout(function () {          // 카드결제중
      wrap02.style.display = "block";
    }, 1000 * 2);
    
    setTimeout(function () {          // 대기번호?
      wrap01.style.display = "none";    
    }, 1000 * 2);
  
  
    setTimeout(function(){              // 메인띄워야 될꺼?
      wrap03.style.display = "block";
    },1000*2);
    
    
    
    
    
    
    
    //  btn.onclick = function() {
    //     modal.style.display = "block";
    //   }
  
    // When the user clicks on <span> (x), close the modal
    setTimeout(function () {
      wrap02.style.display = "none";
    }, 1000*10);
  
  
    // span.onclick = function () {
    //   modal.style.display = "none";
    // }
  
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
    }
  
  }