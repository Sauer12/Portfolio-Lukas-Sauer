// Základné premenné
var totalScore, roundScore, activePlayer, dice, playGame;

newStart();

// Vynulovanie score a odstranenie kocky
function newStart(){

    totalScore = [0, 0];
    activePlayer = 0;
    roundScore = 0;
    playGame = true;
    document.querySelector("#totalScorePlayerX").textContent = 0;
    document.querySelector("#totalScorePlayerY").textContent = 0;
    document.querySelector("#currentScore-X").textContent = 0;
    document.querySelector("#currentScore-Y").textContent = 0;

    document.querySelector(".diceImage").style.display = "none";

    // texty do pôvodného stavu
    document.querySelector("#name-x").textContent = "Skóre 1. hráča";
    document.querySelector("#name-y").textContent = "Skóre 2. hráča";

    // vrátime zvýraznenie prvému hráčovi a druhému ho odstraníme
    document.querySelector(".totalScoreX").classList.add("active");
    document.querySelector(".totalScoreY").classList.remove("active");
}


//Hodiť kockou
document.querySelector(".rollDice").addEventListener("click", function(){
    if(playGame){
        // 1. generujeme náhodné číslo
        dice = Math.ceil(Math.random()*6);
        
        // 2. zobrazenie správneho obrázka
        var diceElement = document.querySelector(".diceImage");
        diceElement.src = "img/" + dice + ".jpg";
        diceElement.style.display = "block";

        // 3. Načítanie čísla z kocky
        if(dice != 1){
            roundScore += dice; 
            if(activePlayer == 0){
                document.querySelector("#currentScore-X").textContent = roundScore;
            }
            else{
                document.querySelector("#currentScore-Y").textContent = roundScore;
            }
        }
        else{
            nextPlayer();
        }
    }
});

//Zmena hráča
function nextPlayer(){
    if(activePlayer == 0){
        activePlayer = 1;
    }
    else{
        activePlayer = 0;
    }

    roundScore = 0;

    document.querySelector("#currentScore-X").textContent = 0;
    document.querySelector("#currentScore-Y").textContent = 0;  

    document.querySelector(".diceImage").style.display = "none";

    document.querySelector(".totalScoreX").classList.toggle("active");
    document.querySelector(".totalScoreY").classList.toggle("active");
}


//Podržať skóre
document.querySelector(".holdScore").addEventListener("click", function(){
    // celkové score sa vyplni súčasným score
    totalScore[activePlayer] += roundScore;
    
    if(activePlayer == 0){
        document.querySelector("#totalScorePlayerX").textContent = totalScore[activePlayer];
    }
    else{
        document.querySelector("#totalScorePlayerY").textContent = totalScore[activePlayer];
    }

    if(totalScore[activePlayer] >= 20){
        if(activePlayer == 0){
            document.querySelector("#name-x").textContent = "Víťaz!";
        }
        else{
            document.querySelector("#name-y").textContent = "Víťaz!";
        }
        document.querySelector(".diceImage").style.display = "none";
        playGame = false;
    }
    else{
        nextPlayer();
    }

    roundScore = 0;
});

//Nová hra
document.querySelector(".newGame").addEventListener("click", newStart);

