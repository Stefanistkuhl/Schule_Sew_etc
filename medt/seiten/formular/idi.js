//der fix war es die funktion in eine variable zu geben quelle:https://www.youtube.com/watch?v=WOAggxx8Sjs
var ichhassejs = function (){
    var geschlecht = "";
    if(document.getElementById("m").checked){
            geschlecht=document.getElementById("m").value
    }
    if(document.getElementById("f").checked){
        geschlecht=document.getElementById("f").value
    }
    if(document.getElementById("n").checked){
        geschlecht=document.getElementById("n").value
    }
    alert(
        document.getElementById("fn").value + " \n" +    
        document.getElementById("ln").value + " \n" +   
        document.getElementById("em").value + " \n" +
        document.getElementById("bd").value + " \n" +
        geschlecht + " \n" +
        document.getElementById("li").value
        
    );
    
}