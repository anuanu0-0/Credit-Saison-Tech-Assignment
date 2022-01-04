function callAPI1(){
    const input = document.getElementById("search").value;
    if (input.length !== 8){
        alert("Not a valid card number!!");
    } else {
        location.href = "/card-scheme/verify/"+input;
    }
}

function callAPI2(){
    location.href = "/card-scheme/stats/";
}