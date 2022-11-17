

let keys=document.querySelectorAll("#bottom > div");
let bag=""
for(let i=0;i<keys.length;i++){
    keys[i].addEventListener("click",clickme)
}
function clickme(event){
let num=event.target.innerText
if(num == "C"){
     bag="";
document.querySelector("#head").innerText=""
}else if(num=="="){
    document.querySelector("#head").innerText=(eval(bag))
}
else{
    bag=bag+num;
document.querySelector("#head").innerText=bag
}

}
