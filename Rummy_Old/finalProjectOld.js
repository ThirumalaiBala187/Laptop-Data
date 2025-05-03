function instruction() {
    var element = document.createElement("div");
    element.classList.add("instructions");
    element.style.justifyContent = "flexEnd";
    element.id = "instructionsParagraph";
    document.getElementById("bg").appendChild(element);

    document.getElementById("bg1").style.filter = "blur(10px)";

    var pTag = document.createElement("p");
    pTag.classList.add("pTagClass");
    document.getElementById("instructionsParagraph").appendChild(pTag);
    pTag.style.fontSize = "65px";
    pTag.style.textDecoration = "underline"
    pTag.style.color = "red";
    pTag.innerText = "Instructions :";

    setTimeout(() => {
        var pTag1 = document.createElement("p");
        pTag1.classList.add("pTagClass");
        document.getElementById("instructionsParagraph").appendChild(pTag1);
        pTag1.style.fontSize = "40px";
        pTag1.innerText += "1. Objective :\n\nForm valid sets and sequences using all your cards. A sequence is three or more cards in a row of the same suit, and a set is three or four cards of the same rank from different suits.";
        pTag1.innerText += "\n\n2. Number of Rounds :\n\nThe game consists of 5 rounds. The player with the lowest total points at the end of all rounds wins.";
        pTag1.innerText += "\n\n3. GamePlay : \n\n- Each player is dealt a set number of cards.\n- Players take turns drawing from the deck or discard pile and discarding one card.\n- Aim to arrange your cards into valid sets and sequences.";
        pTag1.innerText += "\n\n4. Winning Conditions : \n\n- A player must have at least two sequences, with one being a pure sequence (no jokers).\n- All cards should be part of valid sets or sequences to declare a win.";
        pTag1.innerText += "\n\n5. Sequences : \n\n- A *pure sequence* contains three or more consecutive cards of the same suit without any jokers.\n- An *impure sequence* may include jokers as substitutes for missing cards.";
        pTag1.innerText += "\n\n6. Sets : \n\n- Sets are three or four cards of the same rank, each from a different suit.\n- Jokers can be used in sets but should not exceed one joker per set.";
        pTag1.innerText += "\n\n7. Point Calculation : \n\n- Non-winning players sum up their points based on ungrouped cards.\n- Aces and face cards are usually worth 10 points each; other cards have face values.";
        var backButton = document.createElement("button");
        backButton.classList.add("back");
        document.getElementById("instructionsParagraph").appendChild(backButton);
        backButton.innerText = "<-- Back";

        backButton.addEventListener("click", function () {
            document.getElementById("bg").removeChild(element);
            document.getElementById("bg1").style.filter = "blur(0px)";
        });
    }, 300);


    // document.getElementById("bg1").style.filter="blur(10px)";


}


document.getElementById("leave").addEventListener("click", function () {
    var input = prompt("Are you sure you want to leave the game (y/n)?");
    if (input == "y") {
        window.location.href = "http://127.0.0.1:5500/JSFINALPROJECT/gameStart.html";
    }
});




function gameInstruction() {
    var element = document.createElement("div");
    element.classList.add("instructions");
    element.style.justifyContent = "flexEnd";
    element.id = "instructionsParagraph";
    element.style.right = "0px";
    document.getElementById("backgroundTable").appendChild(element);

    document.getElementById("leave").style.filter = "blur(10px)";


    var pTag = document.createElement("p");
    pTag.classList.add("pTagClass");
    pTag.style.textAlign = "left";
    document.getElementById("instructionsParagraph").appendChild(pTag);
    pTag.style.fontSize = "65px";
    pTag.style.textDecoration = "underline"
    pTag.style.color = "red";
    pTag.innerText = "Instructions :";

    var pTag1 = document.createElement("p");
    pTag1.classList.add("pTagClass");
    document.getElementById("instructionsParagraph").appendChild(pTag1);
    pTag1.style.fontSize = "40px";
    pTag1.style.textAlign = "left";
    pTag1.innerText += "1. Objective :\n\nForm valid sets and sequences using all your cards. A sequence is three or more cards in a row of the same suit, and a set is three or four cards of the same rank from different suits.";
    pTag1.innerText += "\n\n2. Number of Rounds :\n\nThe game consists of 5 rounds. The player with the lowest total points at the end of all rounds wins.";
    pTag1.innerText += "\n\n3. GamePlay : \n\n- Each player is dealt a set number of cards.\n- Players take turns drawing from the deck or discard pile and discarding one card.\n- Aim to arrange your cards into valid sets and sequences.";
    pTag1.innerText += "\n\n4. Winning Conditions : \n\n- A player must have at least two sequences, with one being a pure sequence (no jokers).\n- All cards should be part of valid sets or sequences to declare a win.";
    pTag1.innerText += "\n\n5. Sequences : \n\n- A *pure sequence* contains three or more consecutive cards of the same suit without any jokers.\n- An *impure sequence* may include jokers as substitutes for missing cards.";
    pTag1.innerText += "\n\n6. Sets : \n\n- Sets are three or four cards of the same rank, each from a different suit.\n- Jokers can be used in sets but should not exceed one joker per set.";
    pTag1.innerText += "\n\n7. Point Calculation : \n\n- Non-winning players sum up their points based on ungrouped cards.\n- Aces and face cards are usually worth 10 points each; other cards have face values.";

    var backButton = document.createElement("button");
    backButton.classList.add("back");
    document.getElementById("instructionsParagraph").appendChild(backButton);
    backButton.innerText = "<-- Back";

    backButton.addEventListener("click", function () {
        document.getElementById("backgroundTable").removeChild(element);
        document.getElementById("leave").style.filter = "blur(0px)";

    });

    // document.getElementById("bg1").style.filter="blur(10px)";


}

function level() {
    while (document.getElementById("bg").firstChild) {
        document.getElementById("bg").removeChild(document.getElementById("bg").firstChild);
    }
    var home = document.createElement("img");
    home.classList.add("homeButton");
    home.src = "homeButton.png";
    document.getElementById("bg").appendChild(home);

    document.getElementById("bg").style.flexDirection = "column";
    document.getElementById("bg").style.justifyContent = "space-Evenly";

    var selectModeText = document.createElement("p");
    selectModeText.classList.add("selectModeFont");
    document.getElementById("bg").appendChild(selectModeText);
    selectModeText.innerText = "Select any mode";

    var selectMode = document.createElement("div");
    selectMode.classList.add("selectModeBox");
    document.getElementById("bg").appendChild(selectMode);
    let levelArray = ["noOfRounds.jpg", "points.jpeg", "timerLimit.jpeg", "series.jpg"];
    let levelText = ["Round-Based", "Points-Based", "Time Limit-Based", "Series-Game"];
    for (let b = 0; b < levelArray.length; b++) {
        var levelBox = document.createElement("div");
        levelBox.classList.add("levels");
        levelBox.id = "option" + (b + 1);
        selectMode.appendChild(levelBox);
        let imgLevel = document.createElement("img");
        imgLevel.src = levelArray[b];
        imgLevel.classList.add("optionsLogo");
        levelBox.appendChild(imgLevel);
        let text = document.createElement("p");
        text.innerText = levelText[b];
        levelBox.appendChild(text);
    }

    home.addEventListener("click", function () {
        location.reload();
    });

    document.getElementById("option1").addEventListener("click", function () {
        var noOfRoundsToPlay = prompt("Enter the no. of rounds you want to play");
        console.log("No.of rounds:", noOfRoundsToPlay);
        loading();
    });

    document.getElementById("option2").addEventListener("click", function () {
        var winningPoints = prompt("Enter the maximum point you want to play for");
        console.log("Maximum winning score:", winningPoints);
        loading();
    });

    document.getElementById("option3").addEventListener("click", function () {
        var timeOfMatch = prompt("Enter the time you want to play in minutes");
        console.log("Given time limit:", timeOfMatch);
        loading();
    });

    document.getElementById("option4").addEventListener("click", function () {
        var noOfmatchesInSeries = prompt("Enter the no. of matches you want to play in this series");
        console.log("No. of matches in the series:", noOfmatchesInSeries);
        loading();
    });
    // selectMode.innerText="Select your mode";
}

function loading() {
    while (document.getElementById("bg").firstChild) {
        document.getElementById("bg").removeChild(document.getElementById("bg").firstChild);
    }
    // console.log("hi")
    // document.getElementById("bg").style.backgroundColor = "rgb(27,182,191)";

    document.getElementById("bg").style.flexDirection = "column";

    var cardImg = document.createElement("div");
    document.getElementById("bg").style.justifyContent = "center";
    cardImg.classList.add("loadingBox");
    document.getElementById("bg").appendChild(cardImg);

    let loadingText = document.createElement("p");
    loadingText.classList.add("loadingText");
    document.getElementById("bg").appendChild(loadingText);
    for (let load = 0; load <= 100; load++) {
        setTimeout(() => {
            loadingText.innerText = `Loading - ${load}%`;
        }, load * 70);
    }


    let loadingBox = document.createElement("div");
    loadingBox.classList.add("loading");
    document.getElementById("bg").appendChild(loadingBox);


    let loadingBoxInner = document.createElement("div");
    loadingBoxInner.classList.add("loadinginner");
    loadingBox.appendChild(loadingBoxInner);

    let loadingImgs = ["loadingCard1.png", "loadingCard2.png", "loadingCard3.png", "loadingCard4.png"];
    // for (let a = 0; a < 6; a++) {
    let myVar = 0;
    let load = setInterval(() => {
        if (myVar < 24) {
            var imgCardLoad = document.createElement("img");
            imgCardLoad.src = `${loadingImgs[myVar % 4]}`;
            imgCardLoad.classList.add("cardImgLoad");
            cardImg.appendChild(imgCardLoad);
            myVar++;
        }
        else {
            clearInterval(load);
            window.location.href = "http://127.0.0.1:5500/JSFINALPROJECT/gamePage.html";
        }
    }, 300)
    // }

}






function start() {

    var cardsShuffleArea = document.createElement("div");
    cardsShuffleArea.classList.add("centerShuffleBox", "flex");


    document.getElementById("backgroundTable").removeChild(document.getElementById("startButton"));
    document.getElementById("backgroundTable").appendChild(cardsShuffleArea);
    cardsShuffleArea.id = "cardAnimation";


    var computer = document.createElement("div");
    computer.classList.add("playersArea", "flex");
    computer.id = "computerArea";
    document.getElementById("backgroundTable").prepend(computer);

    var whoseTurn = document.createElement("div");
    whoseTurn.classList.add("turn");
    document.getElementById("backgroundTable").prepend(whoseTurn);


    var player1 = document.createElement("div");
    player1.classList.add("playersArea", "flex");
    player1.id = "player1";
    player1.style.marginTop = "2%";
    document.getElementById("backgroundTable").append(player1);


    var playerImagesArea = document.createElement("div");
    playerImagesArea.classList.add("playersImages", "flex");
    document.getElementById("backgroundTable").appendChild(playerImagesArea);


    var player1LogoName = document.createElement("div");
    player1LogoName.classList.add("playerLogo");
    player1LogoName.style.backgroundImage = "url('playerLogo.png";
    playerImagesArea.appendChild(player1LogoName);


    var playerImagesArea1 = document.createElement("div");
    playerImagesArea1.classList.add("playersImages", "flex");
    playerImagesArea1.style.position = "absolute";
    playerImagesArea1.style.marginTop = "-800px"
    document.getElementById("backgroundTable").prepend(playerImagesArea1);


    var player1LogoName1 = document.createElement("div");
    player1LogoName1.classList.add("playerLogo");
    player1LogoName1.style.borderColor = "rgb(17,170,134)";
    player1LogoName1.style.width = "28%";
    player1LogoName1.style.backgroundImage = "url('computerLogo.jpeg";
    playerImagesArea1.appendChild(player1LogoName1);


    var newGroupButton = document.createElement("button");
    newGroupButton.id = "newGroup";
    playerImagesArea.prepend(newGroupButton);


    var sortButton = document.createElement("button");
    sortButton.id = "sort";
    playerImagesArea.appendChild(sortButton);


    var dropButton = document.createElement("button");
    dropButton.id = "drop";
    document.getElementById("backgroundTable").append(dropButton);
    dropButton.classList.add("dropButton", "flex");
    dropButton.innerText = "Drop";
    dropButton.style.opacity = "0%"

    for (let i = 0; i < 3; i++) {
        var processArea = document.createElement("div");
        processArea.classList.add("cardInner", "flex");
        document.getElementById("cardAnimation").append(processArea);
        processArea.id = "processArea" + (i + 1);
        // console.log(processArea.id);
    }


    document.getElementById("processArea2").innerText = "Previous Cards";
    document.getElementById("processArea3").innerText = "Finish Slot";


    var cardNumbers = 1;
    var cardIdsList = [];
    var dummyVar = 0;
    var cardLimit = 26;
    var oneCardDrag = 0;
    var wildJoker = null;


    var entryAnimation = setInterval(() => {

        var cardImg = document.createElement("img");
        cardImg.src = "RummyCards/cards" + cardNumbers + ".png";
        cardImg.id = "card" + cardNumbers;
        cardImg.classList.add("cardSize");
        cardIdsList.push(cardImg.id);
        cardImg.draggable = true;
        // console.log(cardImg.id);
        document.getElementById("processArea1").appendChild(cardImg);
        // console.log(cardNumbers);
        cardNumbers++;

        if (cardNumbers > 55) {
            clearInterval(entryAnimation);
            toss(player1, computer);
            // console.log(document.getElementById("processArea1"));
        }

    }, 100);


    function toss(player1, computer) {
        var childCards = Array.from(document.getElementById("processArea1").children);
        console.log(childCards);
        player1.style.justifyContent = "center";
        computer.style.justifyContent = "center";
        var playerNumForToss = Math.floor(Math.random() * (55 - 1)) + 1;
        player1.appendChild(childCards[playerNumForToss - 1]);
        var computerNumForToss = Math.floor(Math.random() * (55 - 1)) + 1;
        if (computerNumForToss != playerNumForToss) {
            computer.appendChild(childCards[computerNumForToss - 1]);

            setTimeout(() => {
                computer.innerText = "";
                if (playerNumForToss < computerNumForToss) {
                    player1.style.marginTop = "-4%";
                    player1.innerText = "Opponent has won the Toss! 🙁";
                    dummyVar = 1;
                    cardLimit = 27;
                }
                else {
                    player1.style.marginTop = "-4%";
                    player1.innerText = "You have won the Toss! 😃";
                }
            }, 2000);

            setTimeout(() => {
                player1.style.marginTop = "0%";
                computer.style.opacity = "100%";
                cardsSplitting(player1, computer);
            }, 4000)
        }

    }

    var cardNumbersToSortP = [], cardNumbersToSortC = [];
    var selectedCards = new Set();

    function cardsSplitting(player1, computer) {

        player1.style.justifyContent = "flex-start";
        computer.style.justifyContent = "flex-start";
        var playerLeft = 100, computerLeft = 100;
        childCards = Array.from(document.getElementById("processArea1").children);
        // console.log("childcards", childCards);
        player1.innerText = "";


        var cardsSplitting = setInterval(() => {

            var randomCardNum = Math.floor(Math.random() * childCards.length) + 1;
            console.log(randomCardNum);

            if (!selectedCards.has(randomCardNum) && randomCardNum < (document.getElementById("processArea1").children.length - 1)) {
                var cardChosenImg = document.createElement("img");
                cardChosenImg.src = `RummyCards/cards${randomCardNum}.png`;
                cardChosenImg.classList.add("cardSize");
                cardChosenImg.id = "card" + randomCardNum;

                if (dummyVar < cardLimit) {
                    dummyVar++;
                    if (dummyVar % 2 == 0) {
                        cardNumbersToSortP.push(randomCardNum);
                        cardChosenImg.style.marginLeft = playerLeft + "px";
                        player1.appendChild(cardChosenImg);
                        cardChosenImg.draggable = true;
                        document.getElementById("processArea1").removeChild(document.getElementById("card" + randomCardNum));
                        playerLeft += 75;
                    }
                    else {
                        cardNumbersToSortC.push(randomCardNum);
                        cardChosenImg.style.marginLeft = computerLeft + "px";
                        cardChosenImg.draggable = true;
                        // cardChosenImg.style.display = "none";
                        // document.getElementById("processArea1").removeChild(childCards[randomCardNum - 1]);
                        document.getElementById("processArea1").removeChild(document.getElementById("card" + randomCardNum));
                        cardChosenImg.style.opacity = "0";
                        computer.appendChild(cardChosenImg);
                        computerLeft += 75;
                    }
                    console.log(document.getElementById("processArea1").children);

                    selectedCards.add(randomCardNum);
                }
                else {
                    clearInterval(cardsSplitting);
                    console.log(cardNumbersToSortP);
                    console.log(cardNumbersToSortC);

                    var whileLoopVariable = 0;

                    while (whileLoopVariable == 0) {
                        randomCardNum = Math.floor(Math.random() * childCards.length) + 1;

                        if (!selectedCards.has(randomCardNum) && randomCardNum < (document.getElementById("processArea1").children.length - 1)) {
                            var cardToRemove = document.getElementById("card" + randomCardNum);
                            selectedCards.add(randomCardNum);
                            console.log("Card to remove from joker", cardToRemove)
                            document.getElementById("processArea1").removeChild(cardToRemove);
                            cardChosenImg = document.createElement("img");
                            cardChosenImg.src = `RummyCards/cards${randomCardNum}.png`;
                            cardChosenImg.classList.add("cardSize");
                            cardChosenImg.id = "card" + randomCardNum;
                            wildJoker = cardChosenImg.id;
                            cardChosenImg.style.transform = "rotate(90deg) translateY(80px)";
                            document.getElementById("processArea1").prepend(cardChosenImg);
                            randomCardNum = Math.floor(Math.random() * childCards.length) + 1;
                            whileLoopVariable++;

                        }

                    }


                    // console.log(document.getElementById("processArea1"));

                    newGroupButton.classList.add("groupAndSortButton", "flex");
                    newGroupButton.innerText = "New Group";

                    sortButton.classList.add("groupAndSortButton", "flex");
                    sortButton.innerText = "Sort";

                    dropButton.style.opacity = "100%"




                    // console.log(document.getElementById("processArea1").children);
                    // cardsDrag();

                }
            }

        }, 100);


    }

    var playerSuitId = 1, computerSuitId = 1;


    document.getElementById("sort").addEventListener("click", function () {


        cardNumbersToSortP = cardNumbersToSortP.sort((a, b) => a - b);
        console.log(cardNumbersToSortP);
        cardNumbersToSortC = cardNumbersToSortC.sort((a, b) => a - b);
        console.log(cardNumbersToSortC);

        while (player1.firstChild) {
            player1.removeChild(player1.firstChild);
        }

        while (computer.firstChild) {
            computer.removeChild(computer.firstChild);
        }


        //For Sorting Players Cards
        var groupCountPlayer = new Map();

        for (let j = 1; j <= 5; j++) {
            groupCountPlayer.set(j, 0);
        }

        for (let k = 0; k < cardNumbersToSortP.length; k++) {
            if (cardNumbersToSortP[k] > 0 && cardNumbersToSortP[k] <= 13) {
                groupCountPlayer.set(1, groupCountPlayer.get(1) + 1);
            }
            else if (cardNumbersToSortP[k] > 13 && cardNumbersToSortP[k] <= 26) {
                groupCountPlayer.set(2, groupCountPlayer.get(2) + 1);
            }
            else if (cardNumbersToSortP[k] > 26 && cardNumbersToSortP[k] <= 39) {
                groupCountPlayer.set(3, groupCountPlayer.get(3) + 1);
            }
            else if (cardNumbersToSortP[k] > 39 && cardNumbersToSortP[k] <= 52) {
                groupCountPlayer.set(4, groupCountPlayer.get(4) + 1);
            }
            else {
                groupCountPlayer.set(5, groupCountPlayer.get(5) + 1);
            }
        }
        console.log("set", groupCountPlayer);
        // console.log("Group Count Size", groupCountPlayer.size);

        let filteredGroupCountForPlayer = new Map([...groupCountPlayer.entries()].filter(([idx, val]) => val > 0));
        console.log("Filtered Group Count", filteredGroupCountForPlayer);
        // console.log("Filtered Group Count Size", filteredGroupCount.size);


        player1.style.justifyContent = "space-between";
        for (let l = 1; l <= filteredGroupCountForPlayer.size; l++) {
            var suits = document.createElement("div");
            suits.id = "playerSuit" + playerSuitId;
            suits.style.width = (((filteredGroupCountForPlayer.get(l) + 1) * 60) + 30) + "px"
            suits.classList.add("suitsToSort", "flex");
            player1.appendChild(suits);
            playerSuitId++;
            console.log(suits.id);
        }

        for (let m = 0; m < cardNumbersToSortP.length; m++) {

            var cardsForSorting = document.createElement("img");
            cardsForSorting.src = `RummyCards/cards${cardNumbersToSortP[m]}.png`;
            cardsForSorting.classList.add("cardSize");
            cardsForSorting.id = "card" + cardNumbersToSortP[m];
            cardsForSorting.draggable = true;
            if (cardNumbersToSortP[m] > 0 && cardNumbersToSortP[m] <= 13) {
                cardsForSorting.style.marginLeft = (document.getElementById("playerSuit1").children.length * 60) + "px";
                document.getElementById("playerSuit1").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortP[m] > 13 && cardNumbersToSortP[m] <= 26) {
                cardsForSorting.style.marginLeft = (document.getElementById("playerSuit2").children.length * 60) + "px";
                document.getElementById("playerSuit2").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortP[m] > 26 && cardNumbersToSortP[m] <= 39) {
                cardsForSorting.style.marginLeft = (document.getElementById("playerSuit3").children.length * 60) + "px";
                document.getElementById("playerSuit3").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortP[m] > 39 && cardNumbersToSortP[m] <= 52) {
                cardsForSorting.style.marginLeft = (document.getElementById("playerSuit4").children.length * 60) + "px";
                document.getElementById("playerSuit4").appendChild(cardsForSorting);
            }
            else {
                cardsForSorting.style.marginLeft = (document.getElementById("playerSuit5").children.length * 60) + "px";
                document.getElementById("playerSuit5").appendChild(cardsForSorting);
            }

        }


        //For Sorting Computer Cards
        var groupCountComputer = new Map();

        for (let n = 1; n <= 5; n++) {
            groupCountComputer.set(n, 0);
        }

        for (let o = 0; o < cardNumbersToSortC.length; o++) {
            if (cardNumbersToSortC[o] > 0 && cardNumbersToSortC[o] <= 13) {
                groupCountComputer.set(1, groupCountComputer.get(1) + 1);
            }
            else if (cardNumbersToSortC[o] > 13 && cardNumbersToSortC[o] <= 26) {
                groupCountComputer.set(2, groupCountComputer.get(2) + 1);
            }
            else if (cardNumbersToSortC[o] > 26 && cardNumbersToSortC[o] <= 39) {
                groupCountComputer.set(3, groupCountComputer.get(3) + 1);
            }
            else if (cardNumbersToSortC[o] > 39 && cardNumbersToSortC[o] <= 52) {
                groupCountComputer.set(4, groupCountComputer.get(4) + 1);
            }
            else {
                groupCountComputer.set(5, groupCountComputer.get(5) + 1);
            }
        }
        console.log("set", groupCountComputer);
        // console.log("Group Count Size", groupCount.size);

        let filteredGroupCountForComputer = new Map([...groupCountComputer.entries()].filter(([idx, val]) => val > 0));
        console.log("Filtered Group Count Computer", filteredGroupCountForComputer);
        // console.log("Filtered Group Count Size", filteredGroupCount.size);


        computer.style.justifyContent = "space-between";
        for (let p = 1; p <= filteredGroupCountForComputer.size; p++) {
            var suits = document.createElement("div");
            suits.id = "computerSuit" + computerSuitId;
            suits.style.width = (((filteredGroupCountForComputer.get(p) + 1) * 60) + 30) + "px"
            suits.classList.add("suitsToSort", "flex");
            computer.appendChild(suits);
            computerSuitId++;
            console.log(suits.id);
            suits.style.opacity = "0%";
        }


        for (let q = 0; q < cardNumbersToSortC.length; q++) {

            cardsForSorting = document.createElement("img");
            cardsForSorting.src = `RummyCards/cards${cardNumbersToSortC[q]}.png`;
            cardsForSorting.classList.add("cardSize");
            cardsForSorting.id = "card" + cardNumbersToSortC[q];
            cardsForSorting.draggable = true;
            cardsForSorting.style.opacity = "0%";


            if (cardNumbersToSortC[q] > 0 && cardNumbersToSortC[q] <= 13) {
                cardsForSorting.style.marginLeft = (document.getElementById("computerSuit1").children.length * 60) + "px";
                document.getElementById("computerSuit1").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortC[q] > 13 && cardNumbersToSortC[q] <= 26) {
                cardsForSorting.style.marginLeft = (document.getElementById("computerSuit2").children.length * 60) + "px";
                document.getElementById("computerSuit2").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortC[q] > 26 && cardNumbersToSortC[q] <= 39) {
                cardsForSorting.style.marginLeft = (document.getElementById("computerSuit3").children.length * 60) + "px";
                document.getElementById("computerSuit3").appendChild(cardsForSorting);
            }
            else if (cardNumbersToSortC[q] > 39 && cardNumbersToSortC[q] <= 52) {
                cardsForSorting.style.marginLeft = (document.getElementById("computerSuit4").children.length * 60) + "px";
                document.getElementById("computerSuit4").appendChild(cardsForSorting);
            }
            else {
                cardsForSorting.style.marginLeft = (document.getElementById("computerSuit5").children.length * 60) + "px";
                document.getElementById("computerSuit5").appendChild(cardsForSorting);
            }

        }

        var selectedCard = null;
        var cardsToMove = document.querySelectorAll(".cardSize");
        var selectedCardParent = null;
        var selectedCardGroup;

        cardsToMove.forEach(card => {
            card.addEventListener("click", function (event) {
                card.style.transform = "translateY(-50px)";
                selectedCard = event.target;
                selectedCardParent = selectedCard.parentNode.id;
                console.log(selectedCardParent);
                selectedCardGroup = Array.from(document.getElementById(selectedCardParent).children);
                // console.log(selectedCardGroup)
            });

            //         let dropContainer1 = document.getElementById("processArea2");
            //         let dropContainer2 = document.getElementById("processArea3");
            //         // var currentlyDraggedCard = null;


            //         card.addEventListener("dragStart", (e) => {
            //             e.dataTransfer.setData("text/plain", e.target.id);
            //             card.classList.add("dragging");
            //         });


            //         dropContainer1.addEventListener("dragover", (e) => {
            //             e.preventDefault();
            //             dropContainer1.style.backgroundColor = "lightgreen";
            //         });

            //         dropContainer1.addEventListener("dragleave", (e) => {
            //             dropContainer1.style.backgroundColor = "lightgrey";
            //         });

            //         dropContainer1.addEventListener("drop", (e) => {
            //             e.preventDefault();
            //             card.style.transform = "translateY(0px)";
            //             card.style.marginLeft = "0px"
            //             document.getElementById("processArea2").appendChild(card);
            //             whoseTurn.innerText = "Computer's Turn";
            //             for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
            //                 selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
            //             }
            //             document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
            //             oneCardDrag = 0;
            //             setTimeout(() => {
            //                 computerGamePlay();
            //             }, 10000);

            //         });


            //         dropContainer2.addEventListener("dragover", (e) => {
            //             e.preventDefault();
            //             dropContainer2.style.backgroundColor = "lightgreen";
            //         });

            //         dropContainer2.addEventListener("dragleave", (e) => {
            //             dropContainer2.style.backgroundColor = "lightgrey";
            //         });

            //         dropContainer2.addEventListener("drop", (e) => {
            //             e.preventDefault();
            //             // let draggedCards=document.querySelector(".dragging");
            //             card.style.transform = "translateY(0px)";
            //             card.style.marginLeft = "0px"
            //             document.getElementById("processArea3").appendChild(card);
            //             // card.classList.remove("dragging");
            //             dropContainer2.style.backgroundColor = "lightBlue";
            //             for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
            //                 selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
            //             }
            //             document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
            //             cardFinalValidation();

            //         });


            // });
        });


        var selectedCard = null;
        // var cardsToMove = document.querySelectorAll(".cardSize");
        var selectedCardParent = null;
        var selectedCardGroup;


        document.addEventListener("keydown", function (event) {

            if (event.key == "Enter" && selectedCard) {
                selectedCard.style.transform = "translateY(0px)";

            }

            else if (event.key == "ArrowLeft" && selectedCard) {
                var selectedIndex = selectedCardGroup.indexOf(selectedCard);
                if (selectedIndex > 0) {
                    var previousCard = selectedCardGroup[selectedIndex - 1];
                    var parent = selectedCard.parentNode;
                    parent.insertBefore(selectedCard, previousCard);
                    let previousMargin = getComputedStyle(previousCard).marginLeft;
                    let selectedMargin = getComputedStyle(selectedCard).marginLeft
                    selectedCard.style.marginLeft = previousMargin;
                    previousCard.style.marginLeft = selectedMargin;
                    selectedCard.style.zIndex = (parseInt(selectedCard.style.zIndex) - 10).toString();
                    previousCard.style.zIndex = (parseInt(previousCard.style.zIndex) + 10).toString();
                    selectedCardGroup = Array.from(document.getElementById(selectedCardParent).children);
                    // console.log(selectedCardGroup)

                }
            }

            else if (event.key == "ArrowRight" && selectedCard) {
                var selectedIndex = selectedCardGroup.indexOf(selectedCard);
                if (selectedIndex < selectedCardGroup.length - 1) {
                    var nextCard = selectedCardGroup[selectedIndex + 1];
                    var parent = selectedCard.parentNode;
                    parent.insertBefore(nextCard, selectedCard);
                    let nextMargin = getComputedStyle(nextCard).marginLeft;
                    let selectedMargin = getComputedStyle(selectedCard).marginLeft
                    selectedCard.style.marginLeft = nextMargin;
                    nextCard.style.marginLeft = selectedMargin;
                    selectedCard.style.zIndex = (parseInt(selectedCard.style.zIndex) + 10).toString();
                    nextCard.style.zIndex = (parseInt(nextCard.style.zIndex) - 10).toString();
                    selectedCardGroup = Array.from(document.getElementById(selectedCardParent).children);

                }
            }

            else if (event.key == "1" && selectedCard) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("playerSuit1").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = ((document.getElementById("playerSuit1").children.length - 1) * 60) + "px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                document.getElementById("playerSuit1").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit1")).width) + 60 + "px";

            }

            else if (event.key == "2" && selectedCard) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("playerSuit2").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = ((document.getElementById("playerSuit2").children.length - 1) * 60) + "px";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                document.getElementById("playerSuit2").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit2")).width) + 60 + "px";

            }

            else if (event.key == "3" && selectedCard) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("playerSuit3").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = ((document.getElementById("playerSuit3").children.length - 1) * 60) + "px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                document.getElementById("playerSuit3").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit3")).width) + 60 + "px";

            }

            else if (event.key == "4" && selectedCard) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("playerSuit4").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = ((document.getElementById("playerSuit4").children.length - 1) * 60) + "px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                document.getElementById("playerSuit4").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit4")).width) + 60 + "px";

            }

            else if (event.key == "5" && selectedCard) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("playerSuit5").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = ((document.getElementById("playerSuit5").children.length - 1) * 60) + "px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                document.getElementById("playerSuit5").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit5")).width) + 60 + "px";

            }

            else if ((event.key == "P" && selectedCard) || (event.key == "p" && selectedCard)) {
                whoseTurn.innerText = "Computer's Turn";
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("processArea2").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = "0px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                oneCardDrag = 0;
                setTimeout(() => {
                    computerGamePlay();
                }, 2000);

            }

            else if ((event.key == "F" && selectedCard) || (event.key == "f" && selectedCard)) {
                document.getElementById(selectedCardParent).removeChild(selectedCard);
                document.getElementById("processArea3").appendChild(selectedCard);
                // console.log(document.getElementById("playerSuit1").children.length)
                selectedCard.style.marginLeft = "0px";
                selectedCard.style.transform = "translateY(0px)";
                for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                    selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                }
                document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                cardFinalValidation();

            }


        });

    });

    newGroupButton.addEventListener("click", function () {
        player1.style.width = (player1.offsetWidth + 240) + "px";
        var suits = document.createElement("div");
        suits.id = "playerSuit" + playerSuitId;
        suits.style.width = "210px"
        suits.classList.add("suitsToSort", "flex");
        player1.appendChild(suits);
        console.log(suits.id);
        playerSuitId++;
    });


    player1.addEventListener("click", function (event) {
        if (event.target == player1.lastElementChild) {
            player1.style.width = (player1.offsetWidth - 240) + "px";
            player1.removeChild(player1.lastElementChild);
            playerSuitId--;
        }
    });


    // cardsToMove.forEach(card => {
    //     card.addEventListener("click", function (event) {
    //         card.style.transform = "translateY(50px)";
    //     });
    // });






    var cardsToDrag = document.getElementById("player1");
    // let draggedCard = null;

    // cardsToDrag.addEventListener("dragstart", (event) => {
    //     if (event.target.classList.contains("cardSize")) {
    //         draggedCard = event.target;
    //         draggedCard.classList.add("dragging");
    //     }
    // });

    // cardsToDrag.addEventListener("dragend", (event) => {
    //     if (draggedCard) {
    //         draggedCard = null;
    //         draggedCard.classList.remove("dragging")
    //     }
    // });

    // cardsToDrag.addEventListener("dragover", (event) => {
    //     event.preventDefault();
    // });

    // cardsToDrag.addEventListener("dragenter", (event) => {
    //     targetCard = event.target;
    //     if (targetCard && targetCard.classList.contains("cardSize") && targetCard != draggedCard) {
    //         targetCard.after(draggedCard);
    //     }
    // });

    // cardsToDrag.addEventListener("dragleave", (event) => {
    //     targetCard = event.target;
    //     if (targetCard && targetCard.classList.contains("cardSize") && targetCard != draggedCard) {
    //         targetCard.before(draggedCard);
    //     }
    // });


    // // Keyboard movement for cards
    // document.addEventListener("keydown", (event) => {
    //     if (draggedCard) {
    //         const step = 10; // Number of pixels to move
    //         const rect = draggedCard.getBoundingClientRect();

    //         // Move left with the left arrow key
    //         if (event.key === "ArrowLeft") {
    //             draggedCard.style.left = rect.left - step + "px";
    //         }

    //         // Move right with the right arrow key
    //         if (event.key === "ArrowRight") {
    //             draggedCard.style.left = rect.left + step + "px";
    //         }

    //         // Optionally, move up or down as well
    //         if (event.key === "ArrowUp") {
    //             draggedCard.style.top = rect.top - step + "px";
    //         }

    //         if (event.key === "ArrowDown") {
    //             draggedCard.style.top = rect.top + step + "px";
    //         }
    //     }
    // });

    // // Reset when dragging leaves the container
    // cardsToDrag.addEventListener("dragleave", () => {
    //     if (draggedCard) {
    //         draggedCard.classList.remove("dragging");
    //         draggedCard = null; // Reset draggedCard
    //     }
    // });

    // console.log(player1.children.length,"Suits count");

    var turnCal = 0;
    var remainingCardsInTheDeck = [];
    oneCardDrag = 0;

    document.getElementById("processArea1").addEventListener("click", function (event) {
        event.target.style.transform = "translateY(0px)";
        if (oneCardDrag == 0) {
            oneCardDrag++;
            console.log(player1.children.length, "Suits count");
            remainingCardsInTheDeck = Array.from(document.getElementById("processArea1").children);

            // console.log(document.getElementById("processArea1").children.length);
            randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
            console.log("Selected numbers from card to check:", randomCardNum);

            let whileLoopVariable = 0;

            while (whileLoopVariable == 0 && randomCardNum < document.getElementById("processArea1").children.length) {

                if (!selectedCards.has(randomCardNum) && randomCardNum < document.getElementById("processArea1").children.length) {
                    whileLoopVariable++;
                }
                else {
                    randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
                }

            }

            selectedCards.add(randomCardNum);
            console.log("My number:", randomCardNum);
            console.log("My cards:", remainingCardsInTheDeck[randomCardNum])
            console.log("My cards id:", remainingCardsInTheDeck[randomCardNum].id);
            
            suits = document.createElement("div");
            suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
            player1.style.width = (player1.offsetWidth + 150) + "px";
            suits.style.width = "150px"
            suits.classList.add("suitsToSort", "flex");
            player1.appendChild(suits);
            console.log(suits.id);
            suits.appendChild(remainingCardsInTheDeck[randomCardNum]);

        }

    })


    // document.getElementById("processArea1").addEventListener("click", function (event) {
    //     event.target.style.transform = "translateY(0px)";
    // if (oneCardDrag == 0) {
    //     oneCardDrag++;
    //     console.log(player1.children.length, "Suits count");
    //     remainingCardsInTheDeck = Array.from(document.getElementById("processArea1").children);

    //     // console.log(document.getElementById("processArea1").children.length);
    //     randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
    //     console.log("Selected numbers from card to check:", randomCardNum);

    //     let whileLoopVariable = 0;

    //     while (whileLoopVariable == 0 && randomCardNum < document.getElementById("processArea1").children.length) {

    //         if (!selectedCards.has(randomCardNum) && randomCardNum < document.getElementById("processArea1").children.length) {
    //             whileLoopVariable++;
    //         }
    //         else {
    //             randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
    //         }

    //     }

    //     selectedCards.add(randomCardNum);
    //     console.log("My number:", randomCardNum);
    //     console.log("My cards:", remainingCardsInTheDeck[randomCardNum])
    //     console.log("My cards id:", remainingCardsInTheDeck[randomCardNum].id)
    //     let cardIdToAppend = +((remainingCardsInTheDeck[randomCardNum].id).replace("card", ""));

    //         console.log(cardIdToAppend)
    //         if (cardIdToAppend > 0 && cardIdToAppend <= 13) {
    //             if (document.getElementById("playerSuit1")) {
    //                 remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("playerSuit1").children.length) * 60 + "px";
    //                 document.getElementById("playerSuit1").appendChild(remainingCardsInTheDeck[randomCardNum]);
    //                 document.getElementById("playerSuit1").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit1")).width) + 60 + "px";

    //             }
    //             else {
    //                 suits = document.createElement("div");
    //                 suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
    //                 player1.style.width = (player1.offsetWidth + 150) + "px";
    //                 suits.style.width = "150px"
    //                 suits.classList.add("suitsToSort", "flex");
    //                 player1.appendChild(suits);
    //                 console.log(suits.id);
    //                 suits.appendChild(remainingCardsInTheDeck[randomCardNum]);

    //             }
    //         }
    //         else if (cardIdToAppend > 13 && cardIdToAppend <= 26) {
    //             if (document.getElementById("playerSuit2")) {
    //                 remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("playerSuit2").children.length) * 60 + "px";
    //                 document.getElementById("playerSuit2").appendChild(remainingCardsInTheDeck[randomCardNum]);
    //                 document.getElementById("playerSuit2").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit2")).width) + 60 + "px";

    //             }
    //             else {
    //                 suits = document.createElement("div");
    //                 suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
    //                 player1.style.width = (player1.offsetWidth + 150) + "px";
    //                 suits.style.width = "150px"
    //                 suits.classList.add("suitsToSort", "flex");
    //                 player1.appendChild(suits);
    //                 console.log(suits.id);
    //                 suits.appendChild(remainingCardsInTheDeck[randomCardNum])

    //             }
    //         }
    //         else if (cardIdToAppend > 26 && cardIdToAppend <= 39) {
    //             if (document.getElementById("playerSuit3")) {
    //                 remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("playerSuit3").children.length) * 60 + "px";
    //                 document.getElementById("playerSuit3").appendChild(remainingCardsInTheDeck[randomCardNum]);
    //                 document.getElementById("playerSuit3").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit3")).width) + 60 + "px";

    //             }
    //             else {
    //                 suits = document.createElement("div");
    //                 suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
    //                 player1.style.width = (player1.offsetWidth + 150) + "px";
    //                 suits.style.width = "150px"
    //                 suits.classList.add("suitsToSort", "flex");
    //                 player1.appendChild(suits);
    //                 console.log(suits.id);
    //                 suits.appendChild(remainingCardsInTheDeck[randomCardNum])


    //             }
    //         }
    //         else if (cardIdToAppend > 39 && cardIdToAppend <= 52) {
    //             if (document.getElementById("playerSuit4")) {
    //                 remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("playerSuit4").children.length) * 60 + "px";
    //                 document.getElementById("playerSuit4").appendChild(remainingCardsInTheDeck[randomCardNum]);
    //                 document.getElementById("playerSuit4").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit4")).width) + 60 + "px";


    //             }
    //             else {
    //                 suits = document.createElement("div");
    //                 suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
    //                 suits.style.width = "150px"
    //                 player1.style.width = (player1.offsetWidth + 150) + "px";
    //                 suits.classList.add("suitsToSort", "flex");
    //                 player1.appendChild(suits);
    //                 console.log(suits.id);
    //                 suits.appendChild(remainingCardsInTheDeck[randomCardNum])

    //             }
    //         }
    //         else if (cardIdToAppend > 52 && cardIdToAppend < 55) {
    //             if (document.getElementById("playerSuit5")) {
    //                 remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("playerSuit5").children.length) * 60 + "px";
    //                 document.getElementById("playerSuit5").appendChild(remainingCardsInTheDeck[randomCardNum]);
    //                 document.getElementById("playerSuit5").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit5")).width) + 60 + "px";


    //             }
    //             else {
    //                 suits = document.createElement("div");
    //                 suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
    //                 suits.style.width = "150px";
    //                 player1.style.width = (player1.offsetWidth + 150) + "px";
    //                 suits.classList.add("suitsToSort", "flex");
    //                 player1.appendChild(suits);
    //                 console.log(suits.id);
    //                 suits.appendChild(remainingCardsInTheDeck[randomCardNum])

    //             }
    //         }


    //     }
    // });


    document.getElementById("processArea2").addEventListener("click", function (event) {
        event.target.style.transform = "translateY(0px)";
        if (oneCardDrag == 0) {
            oneCardDrag++;
            console.log(player1.children.length, "Suits count");
            let cardIdToAppend = parseInt((document.getElementById("processArea2").lastChild.id).replace("card", ""));
            console.log("Recent card Id", cardIdToAppend)
            let cardToAppend = document.getElementById("processArea2").lastChild;

            if (cardIdToAppend > 0 && cardIdToAppend <= 13) {
                if (document.getElementById("playerSuit1")) {
                    (document.getElementById("processArea2").lastChild).style.marginLeft = (document.getElementById("playerSuit1").children.length) * 60 + "px";
                    document.getElementById("playerSuit1").appendChild((document.getElementById("processArea2").lastChild));
                    document.getElementById("playerSuit1").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit1")).width) + 60 + "px";

                }
                else {
                    suits = document.createElement("div");
                    suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                    player1.style.width = (player1.offsetWidth + 150) + "px";
                    suits.style.width = "150px"
                    suits.classList.add("suitsToSort", "flex");
                    player1.appendChild(suits);
                    console.log(suits.id);
                    suits.appendChild(document.getElementById("processArea2").lastChild)

                }
            }
            else if (cardIdToAppend > 13 && cardIdToAppend <= 26) {
                if (document.getElementById("playerSuit2")) {
                    cardToAppend.style.marginLeft = (document.getElementById("playerSuit2").children.length) * 60 + "px";
                    document.getElementById("playerSuit2").appendChild(document.getElementById("processArea2").lastChild);
                    document.getElementById("playerSuit2").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit2")).width) + 60 + "px";

                }
                else {
                    suits = document.createElement("div");
                    suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                    player1.style.width = (player1.offsetWidth + 150) + "px";
                    suits.style.width = "150px"
                    suits.classList.add("suitsToSort", "flex");
                    player1.appendChild(suits);
                    console.log(suits.id);
                    suits.appendChild(document.getElementById("processArea2").lastChild)

                }
            }
            else if (cardIdToAppend > 26 && cardIdToAppend <= 39) {
                if (document.getElementById("playerSuit3")) {
                    cardToAppend.style.marginLeft = (document.getElementById("playerSuit3").children.length) * 60 + "px";
                    document.getElementById("playerSuit3").appendChild(document.getElementById("processArea2").lastChild);
                    document.getElementById("playerSuit3").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit3")).width) + 60 + "px";

                }
                else {
                    suits = document.createElement("div");
                    suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                    player1.style.width = (player1.offsetWidth + 150) + "px";
                    suits.style.width = "150px"
                    suits.classList.add("suitsToSort", "flex");
                    player1.appendChild(suits);
                    console.log(suits.id);
                    suits.appendChild(document.getElementById("processArea2").lastChild)

                }
            }
            else if (cardIdToAppend > 39 && cardIdToAppend <= 52) {
                if (document.getElementById("playerSuit4")) {
                    cardToAppend.style.marginLeft = (document.getElementById("playerSuit4").children.length) * 60 + "px";
                    document.getElementById("playerSuit4").appendChild(document.getElementById("processArea2").lastChild);
                    document.getElementById("playerSuit4").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit4")).width) + 60 + "px";


                }
                else {
                    suits = document.createElement("div");
                    suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                    suits.style.width = "150px"
                    player1.style.width = (player1.offsetWidth + 150) + "px";
                    suits.classList.add("suitsToSort", "flex");
                    player1.appendChild(suits);
                    console.log(suits.id);
                    suits.appendChild(document.getElementById("processArea2").lastChild)

                }
            }
            else if (cardIdToAppend > 52 && cardIdToAppend < 55) {
                if (document.getElementById("playerSuit5")) {
                    cardToAppend.style.marginLeft = (document.getElementById("playerSuit5").children.length) * 60 + "px";
                    document.getElementById("playerSuit5").appendChild(document.getElementById("processArea2").lastChild);
                    document.getElementById("playerSuit5").style.width = parseFloat(getComputedStyle(document.getElementById("playerSuit5")).width) + 60 + "px";


                }
                else {
                    suits = document.createElement("div");
                    suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                    suits.style.width = "150px";
                    player1.style.width = (player1.offsetWidth + 150) + "px";
                    suits.classList.add("suitsToSort", "flex");
                    player1.appendChild(suits);
                    console.log(suits.id);
                    suits.appendChild(document.getElementById("processArea2").lastChild)

                }
            }

        }
    });





    // var pureSequence = 0, impureSequence = 0, setA = 0, setB = 0;
    // var countForPenalty = 0;

    // function cardFinalValidation() {

    //     outerLoop1: for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
    //         if (document.getElementById("playerSuit" + finalValid)) {
    //             let arrayToValidate = Array.from(document.getElementById("playerSuit" + finalValid).children);
    //             count = 0;

    //             innerLoop1: for (let childId = 0; childId < arrayToValidate.length - 1; childId++) {
    //                 if (arrayToValidate[childId].id == wildJoker) {
    //                     continue outerLoop1;
    //                 }
    //                 else if ((parseInt(arrayToValidate[childId + 1].id.replace("card", "")) - parseInt(arrayToValidate[childId].id.replace("card", ""))) == 1) {
    //                     continue innerLoop1;
    //                 }
    //                 else {
    //                     countForPenalty += parseInt(arrayToValidate[childId].id.replace("card", "")) % 13;
    //                 }
    //             }
    //             pureSequence++;
    //         }
    //     }


    //     outerLoop2: for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
    //         if (document.getElementById("playerSuit" + finalValid)) {
    //             let arrayToValidate = Array.from(document.getElementById("playerSuit" + finalValid).children);
    //             count = 0;

    //             innerLoop2: for (let childId = 0; childId < arrayToValidate.length - 1; childId++) {
    //                 if (arrayToValidate[childId + 1].id == wildJoker) {
    //                     wildJoker.id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 1);
    //                 }
    //                 if (parseInt(arrayToValidate[childId + 1].id.replace("card", "")) > 52) {
    //                     arrayToValidate[childId + 1].id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 1);
    //                 }
    //                 if ((parseInt(arrayToValidate[childId + 1].id.replace("card", "")) - parseInt(arrayToValidate[childId].id.replace("card", ""))) == 1) {
    //                     continue innerLoop2;
    //                 }
    //                 else {
    //                     countForPenalty += parseInt(arrayToValidate[childId].id.replace("card", "")) % 13;
    //                 }
    //             }
    //             impureSequence++;
    //         }
    //     }


    //     outerLoop3: for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
    //         if (document.getElementById("playerSuit" + finalValid)) {
    //             let arrayToValidate = Array.from(document.getElementById("playerSuit" + finalValid).children);
    //             count = 0;

    //             innerLoop3: for (let childId = 0; childId < arrayToValidate.length - 1; childId++) {
    //                 if (arrayToValidate[childId + 1].id == wildJoker) {
    //                     wildJoker.id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 13);
    //                 }
    //                 if (parseInt(arrayToValidate[childId + 1].id.replace("card", "")) > 52) {
    //                     arrayToValidate[childId + 1].id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 13);
    //                 }
    //                 if (count > arrayToValidate.length) {
    //                     continue outerLoop3;
    //                 } 
    //                 else if ((parseInt(arrayToValidate[childId + 1].id.replace("card", "")) - parseInt(arrayToValidate[childId].id.replace("card", ""))) == 13) {
    //                     continue innerLoop3;
    //                 }
    //                  else {
    //                     countForPenalty += parseInt(arrayToValidate[childId].id.replace("card", "")) % 13;

    //                 }
    //             }
    //             setA++;
    //         }
    //     }


    //     outerLoop4: for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
    //         if (document.getElementById("playerSuit" + finalValid)) {
    //             let arrayToValidate = Array.from(document.getElementById("playerSuit" + finalValid).children);
    //             count = 0;

    //             innerLoop4: for (let childId = 0; childId < arrayToValidate.length - 1; childId++) {
    //                 if (arrayToValidate[childId + 1].id == wildJoker) {
    //                     wildJoker.id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 13);
    //                 }
    //                 if (parseInt(arrayToValidate[childId + 1].id.replace("card", "")) > 52) {
    //                     arrayToValidate[childId + 1].id = "card" + (parseInt(arrayToValidate[childId].id.replace("card", "")) + 13);
    //                 }
    //                 if ((parseInt(arrayToValidate[childId + 1].id.replace("card", "")) - parseInt(arrayToValidate[childId].id.replace("card", ""))) == 13) {
    //                     continue innerLoop4;
    //                 }
    //                 else {
    //                     countForPenalty += parseInt(arrayToValidate[childId].id.replace("card", "")) % 13;
    //                 }
    //             }
    //             setB++;
    //         }
    //     }

    // // Winner Condition Check
    // if (player1.children.length == 3) {
    //     if (pureSequence == 1 && impureSequence == 1 && setA == 1 && setB == 1) {
    //         console.log("winner");
    //     }
    // }
    // else if (player1.children.length == 4) {
    //     if ((pureSequence == 1 && impureSequence == 1 && setB == 1 || (pureSequence == 1 && impureSequence == 1 && setA == 1))) {
    //         console.log("winner");
    //     }
    // }

    // }


    var countForPenalty = 0;
    var pureSequence = 0, impureSequence = 0, setA = 0, setB = 0;


    function cardFinalValidation() {
        for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
            var playerSuit = document.getElementById("playerSuit" + finalValid);
            if (playerSuit) {
                let arrayToValidate = Array.from(playerSuit.children);
                pureSequenceValidation(arrayToValidate);
                if (pureSequence != 1) {
                    impureSequenceValidation(arrayToValidate);
                    if (impureSequence != 1) {
                        setAValidation(arrayToValidate);
                        if (setA != 1) {
                            setBValidation(arrayToValidate);
                        }
                    }
                }
            }
            pureSequence = 0, impureSequence = 0, setA = 0, setB = 0;

        }

        winningCheck();
    }


    function cardFinalValidationComputer() {
        for (let finalValid = 1; finalValid <= player1.children.length; finalValid++) {
            var computerSuit = document.getElementById("computerSuit" + finalValid);
            if (computerSuit) {
                let arrayToValidate = Array.from(computerSuit.children);
                pureSequenceValidation(arrayToValidate);
                if (pureSequence != 1) {
                    impureSequenceValidation(arrayToValidate);
                    if (impureSequence != 1) {
                        setAValidation(arrayToValidate);
                        if (setA != 1) {
                            setBValidation(arrayToValidate);
                        }
                    }
                }
            }
            winningCheckComputer();
            pureSequence = 0, impureSequence = 0, setA = 0, setB = 0;

        }
        whoseTurn.innerText = "Your Turn";
    }

    function pureSequenceValidation(arrayToValidate) {
        for (let childId = 0; childId < arrayToValidate.length; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId;
            if (currentId + 1 < arrayToValidate.length) {
                nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));
            }
            else {
                nextId = null;
            }

            if (arrayToValidate[childId] == wildJoker) {
                return;
            }
            else if (nextId != null && nextId - currentId == 1) {
                continue;
            }
            else {
                countForPenalty += currentId % 13;
            }
        }
        pureSequence++;
    }


    function impureSequenceValidation(arrayToValidate) {
        for (let childId = 0; childId < arrayToValidate.length; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId;
            if (currentId + 1 < arrayToValidate.length) {
                nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));
            }
            else {
                nextId = null;
            }
            if (currentId == 53 || currentId == 54) {
                currentId = nextId - 1;
            }

            if (nextId == 53 || nextId == 54) {
                nextId = currentId + 1;
            }

            if (arrayToValidate[childId + 1] == wildJoker) {
                wildJoker.id = "card" + nextId;
            }
            if (nextId != null && nextId - currentId == 1) {
                continue;
            }
            else {
                countForPenalty += currentId % 13;
            }
        }
        impureSequence++;
    }

    function setAValidation(arrayToValidate) {
        for (let childId = 0; childId < arrayToValidate.length; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId;
            if (currentId + 1 < arrayToValidate.length) {
                nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));
            }
            else {
                nextId = null;
            }

            if (arrayToValidate[childId + 1] == wildJoker) {
                wildJoker.id = "card" + (currentId + 13);
            }
            if (currentId == 53 || currentId == 54) {
                currentId = nextId - 1;
            }

            if (nextId == 53 || nextId == 54) {
                nextId = currentId + 1;
            }
            if (nextId != null && nextId - currentId == 13) {
                continue;
            }
            else {
                countForPenalty += currentId % 13;
            }
        }
        setA++;
    }

    function setBValidation(arrayToValidate) {
        for (let childId = 0; childId < arrayToValidate.length; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId;
            if (currentId + 1 < arrayToValidate.length) {
                nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));
            }
            else {
                nextId = null;
            }

            if (arrayToValidate[childId + 1] == wildJoker) {
                wildJoker.id = "card" + (currentId + 13);
            }
            if (currentId == 53 || currentId == 54) {
                currentId = nextId - 1;
            }

            if (nextId == 53 || nextId == 54) {
                nextId = currentId + 1;
            }
            if (nextId != null && nextId - currentId == 13) {
                continue;
            }
            else {
                countForPenalty += currentId % 13;
            }
        }
        setB++;
    }

    function winningCheck() {

        if (player1.children.length == 3) {
            if (pureSequence == 1 && impureSequence == 1 && setA == 1 && setB == 1) {
                // console.log("winner");
                var img = document.createElement("img");
                img.src = "winner.jpeg";
                img.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(img);
                // document.getElementById("backgroundTable").innerHTML = img;

            }
            else {
                var finalImgLoser = document.createElement("img");
                finalImgLoser.src = "loser.jpg";
                finalImgLoser.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(finalImgLoser);
                // document.getElementById("backgroundTable").innerHTML = finalImgLoser;


            }
        }

        else if (player1.children.length == 4) {
            if ((pureSequence == 1 && impureSequence == 1 && setA == 1 || (pureSequence == 1 && impureSequence == 1 && setB == 1))) {
                // console.log("winner");
                var img = document.createElement("img");
                img.src = "winner.jpeg";
                img.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(img);
                // document.getElementById("backgroundTable").innerHTML = img;

            }
            else {
                var finalImgLoser = document.createElement("img");
                finalImgLoser.src = "loser.jpg";
                finalImgLoser.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(finalImgLoser);
                // document.getElementById("backgroundTable").innerHTML = finalImgLoser;

            }
        }
        else if ((pureSequence == 1 && pureSequence + impureSequence + setA + setB == player1.children.length)) {
            // console.log("winner");
            var img = document.createElement("img");
            img.src = "winner.jpeg";
            img.classList.add("finalImg");
            while (document.getElementById("backgroundTable").firstChild) {
                document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
            }
            document.getElementById("backgroundTable").appendChild(img);
            // document.getElementById("backgroundTable").innerHTML = img;

        }


        else {
            var finalImgLoser = document.createElement("img");
            finalImgLoser.src = "loser.jpg";
            finalImgLoser.classList.add("finalImg");
            while (document.getElementById("backgroundTable").firstChild) {
                document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
            }
            document.getElementById("backgroundTable").appendChild(finalImgLoser);
            // document.getElementById("backgroundTable").innerHTML = finalImgLoser;

        }
    }

    function winningCheckComputer() {

        if (computer.children.length == 3) {
            if (pureSequence == 1 && impureSequence == 1 && setA == 1 && setB == 1) {
                document.getElementById("processArea3").appendChild(document.getElementById("processArea2").lastChild);
                document.getElementById("processArea2").removeChild(document.getElementById("processArea2").lastChild);
                computer.style.opacity = "100%";
                // console.log("winner");
                var img = document.createElement("img");
                img.src = "loser.jpg";
                img.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(img);
            }
        }

        else if (computer.children.length == 4) {
            if ((pureSequence == 1 && impureSequence == 1 && setA == 1 || (pureSequence == 1 && impureSequence == 1 && setB == 1))) {
                document.getElementById("processArea3").appendChild(document.getElementById("processArea2").lastChild);
                document.getElementById("processArea2").removeChild(document.getElementById("processArea2").lastChild);
                computer.style.opacity = "100%";
                // console.log("winner");
                var img = document.createElement("img");
                img.src = "loser.jpg";
                img.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(img);
            }
        }
        else if ((pureSequence == 1 && pureSequence + impureSequence + setA + setB == player1.children.length)) {
            document.getElementById("processArea3").appendChild(document.getElementById("processArea2").lastChild);
            document.getElementById("processArea2").removeChild(document.getElementById("processArea2").lastChild);
            computer.style.opacity = "100%";
            // console.log("winner");
            var img = document.createElement("img");
            img.src = "loser.jpg";
            img.classList.add("finalImg");
            while (document.getElementById("backgroundTable").firstChild) {
                document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
            }
            document.getElementById("backgroundTable").appendChild(img);
        }
    }


    function computerGamePlay() {
        oneCardDrag = 0;

        remainingCardsInTheDeck = Array.from(document.getElementById("processArea1").children);

        // console.log(document.getElementById("processArea1").children.length);
        randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
        console.log("Selected numbers from card to check:", randomCardNum);

        let whileLoopVariable = 0;

        while (whileLoopVariable == 0 && randomCardNum < document.getElementById("processArea1").children.length) {

            if (!selectedCards.has(randomCardNum) && randomCardNum < document.getElementById("processArea1").children.length) {
                whileLoopVariable++;
                selectedCards.add(randomCardNum);
            }
            else {
                randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;

                whileLoopVariable = 0;
            }

        }


        var removedCard;
        // player1LogoName1.style.backgroundImage = "url('computerThinking.gif')";
        remainingCardsInTheDeck = document.getElementById("processArea1").children;

        randomCardNum = Math.floor(Math.random() * remainingCardsInTheDeck.length) + 1;
        let cardIdToAppend = parseInt((remainingCardsInTheDeck[randomCardNum].id).replace("card", ""));
        console.log(cardIdToAppend);
        document.getElementById((remainingCardsInTheDeck[randomCardNum].id)).style.opacity = "0%"
        if (cardIdToAppend > 0 && cardIdToAppend <= 13) {
            if (document.getElementById("computerSuit1")) {
                remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("computerSuit1").children.length) * 60 + "px";
                document.getElementById("computerSuit1").appendChild(remainingCardsInTheDeck[randomCardNum]);
                remainingCardsInTheDeck[randomCardNum].id = "card" + cardIdToAppend;
                document.getElementById("computerSuit1").style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit1")).width) + 60 + "px";

            }
            else {
                suits = document.createElement("div");
                suits.id = "computerSuit" + (computer.children.length + 1);
                suits.style.width = "150px";
                suits.style.opacity = "0%";
                suits.classList.add("suitsToSort", "flex");
                computer.style.width = (computer.offsetWidth + 150) + "px";
                computer.appendChild(suits);
                console.log(suits.id);
                suits.appendChild(remainingCardsInTheDeck[randomCardNum])

            }
        }
        else if (cardIdToAppend > 13 && cardIdToAppend <= 26) {
            if (document.getElementById("computerSuit2")) {
                remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("computerSuit2").children.length) * 60 + "px";
                document.getElementById("computerSuit2").appendChild(remainingCardsInTheDeck[randomCardNum]);
                document.getElementById("computerSuit2").style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit2")).width) + 60 + "px";

            }
            else {
                suits = document.createElement("div");
                suits.id = "computerSuit" + (computer.children.length + 1);
                suits.style.width = "150px";
                suits.style.opacity = "0%";
                computer.style.width = (computer.offsetWidth + 150) + "px";
                suits.classList.add("suitsToSort", "flex");
                computer.appendChild(suits);
                console.log(suits.id);
                suits.appendChild(remainingCardsInTheDeck[randomCardNum])

            }
        }
        else if (cardIdToAppend > 26 && cardIdToAppend <= 39) {
            if (document.getElementById("computerSuit3")) {
                remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("computerSuit3").children.length) * 60 + "px";
                document.getElementById("computerSuit3").appendChild(remainingCardsInTheDeck[randomCardNum]);
                document.getElementById("computerSuit3").style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit3")).width) + 60 + "px";

            }
            else {
                suits = document.createElement("div");
                suits.id = "computerSuit" + (computer.children.length + 1);
                suits.style.width = "150px";
                suits.style.opacity = "0%";
                computer.style.width = (computer.offsetWidth + 150) + "px";
                suits.classList.add("suitsToSort", "flex");
                computer.appendChild(suits);
                console.log(suits.id);
                suits.appendChild(remainingCardsInTheDeck[randomCardNum])


            }
        }
        else if (cardIdToAppend > 39 && cardIdToAppend <= 52) {
            if (document.getElementById("computerSuit4")) {
                remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("computerSuit4").children.length) * 60 + "px";
                document.getElementById("computerSuit4").appendChild(remainingCardsInTheDeck[randomCardNum]);
                document.getElementById("computerSuit4").style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit4")).width) + 60 + "px";


            }
            else {
                suits = document.createElement("div");
                suits.id = "computerSuit" + (computer.children.length + 1);
                suits.style.width = "150px";
                computer.style.width = (computer.offsetWidth + 150) + "px";
                suits.classList.add("suitsToSort", "flex");
                computer.appendChild(suits);
                suits.style.opacity = "0%";
                console.log(suits.id);
                suits.appendChild(remainingCardsInTheDeck[randomCardNum])

            }
        }
        else if (cardIdToAppend > 52 && cardIdToAppend < 55) {
            if (document.getElementById("computerSuit5")) {
                remainingCardsInTheDeck[randomCardNum].style.marginLeft = (document.getElementById("computerSuit5").children.length) * 60 + "px";
                document.getElementById("computerSuit5").appendChild(remainingCardsInTheDeck[randomCardNum]);
                document.getElementById("computerSuit5").style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit5")).width) + 60 + "px";


            }
            else {
                suits = document.createElement("div");
                suits.id = "computerSuit" + (computer.children.length + 1);
                suits.style.width = "150px";
                computer.style.width = (computer.offsetWidth + 150) + "px";
                suits.classList.add("suitsToSort", "flex");
                computer.appendChild(suits);
                console.log(suits.id);
                suits.style.opacity = "0%";
                suits.appendChild(remainingCardsInTheDeck[randomCardNum])

            }
        }

        var maximumNumber = [];
        for (let computerSuits = 1; computerSuits <= computer.children.length; computerSuits++) {
            var eachCalculationArray = [];
            let computerSuitElement = document.getElementById("computerSuit" + computerSuits);
            let computerSuitChilds = Array.from(computerSuitElement.children);
            console.log("Computer Suit Child", computerSuitChilds);
            for (let suitsInnerCards = 0; suitsInnerCards < computerSuitChilds.length; suitsInnerCards++) {
                console.log(computerSuitChilds[suitsInnerCards]);
                var currentID = parseInt((computerSuitChilds[suitsInnerCards].id).replace("card", ""));
                console.log("Computer current ID", currentID);
                if (suitsInnerCards < computerSuitChilds.length - 1) {
                    var nextID = parseInt(((computerSuitChilds[suitsInnerCards + 1]).id).replace("card", ""));
                    eachCalculationArray.push(nextID - currentID);
                }
                else {
                    break;
                }
            }
            maximumNumber.push(Math.max(...eachCalculationArray));
        }
        let cardToPush = Math.max(...maximumNumber);


        setTimeout(() => {

            for (let computerSuits = 1; computerSuits <= computer.children.length; computerSuits++) {
                var eachCalculationArray = [];
                let computerSuitChilds = Array.from(document.getElementById("computerSuit" + computerSuits).children);
                if (computerSuitChilds.length == 1 && parseInt((computerSuitChilds[0].id).replace("card", "")) <= 52 && parseInt((computerSuitChilds[0].id).replace("card", "")) == parseInt((wildJoker.id).replace("card", ""))) {
                    document.getElementById("computerSuit" + computerSuits).removeChild(document.getElementById("computerSuit" + computerSuits).firstChild);
                    (document.getElementById("computerSuit" + computerSuits).firstChild).style.marginLeft = "0px";
                    (document.getElementById("computerSuit" + computerSuits).firstChild).style.marginLeft = (parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits).firstChild).marginLeft) - parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits).firstChild).marginLeft)) + "px";
                    (document.getElementById("computerSuit" + computerSuits).firstChild).style.opacity = "100%";
                    document.getElementById("processArea2").appendChild((document.getElementById("computerSuit" + computerSuits).firstChild));
                }
                else {
                    for (let suitsInnerCards = 0; suitsInnerCards < computerSuitChilds.length; suitsInnerCards++) {
                        var currentID = parseInt(computerSuitChilds[suitsInnerCards].id.replace("card", ""));
                        console.log("Current id", currentID);
                        let previousID = suitsInnerCards > 0 ? parseInt(computerSuitChilds[suitsInnerCards - 1].id.replace("card", "")) : 0;
                        let nextID = suitsInnerCards < computerSuitChilds.length - 1 ? parseInt(computerSuitChilds[suitsInnerCards + 1].id.replace("card", "")) : 0;
                        if (nextID != 0) {
                            eachCalculationArray.push(nextID - currentID);
                            if ((currentID > 52 && currentID <= 54) || (nextID > 52 && nextID <= 54)) {
                                continue;
                            }
                            else if (nextID - currentID == cardToPush) {
                                let removedCard;

                                if (previousID !== 0 && currentID - previousID > nextID - currentID) {
                                    removedCard = document.getElementById("card" + previousID);
                                    removedCard.style.marginLeft = (parseFloat(getComputedStyle(removedCard).marginLeft) - parseFloat(getComputedStyle(removedCard).marginLeft)) + "px";
                                    removedCard.style.marginLeft = "0px";
                                    console.log("Removed Card", removedCard);
                                    document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                                    document.getElementById("processArea2").appendChild(removedCard);
                                    removedCard.style.opacity = "100%";
                                    document.getElementById("computerSuit" + computerSuits).style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits)).width) - 60 + "px";


                                    for (let r = suitsInnerCards + 1; r < computerSuitChilds.length; r++) {
                                        computerSuitChilds[r].style.marginLeft = (r - 1) * 60 + "px";
                                    }
                                    // break;
                                    // removedCard.style.marginLeft = "0px";
                                }
                                else {
                                    removedCard = document.getElementById("card" + nextID);
                                    console.log("Removed Card", removedCard);
                                    removedCard.style.marginLeft = (parseFloat(getComputedStyle(removedCard).marginLeft) - parseFloat(getComputedStyle(removedCard).marginLeft)) + "px";
                                    removedCard.style.marginLeft = "0px";
                                    removedCard.style.opacity = "100%";
                                    document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                                    document.getElementById("processArea2").appendChild(removedCard);
                                    document.getElementById("computerSuit" + computerSuits).style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits)).width) - 60 + "px";

                                    removedCard.style.marginLeft = "0px";

                                    for (let r = suitsInnerCards + 1; r < computerSuitChilds.length; r++) {
                                        computerSuitChilds[r].style.marginLeft = (r - 1) * 60 + "px";
                                    }
                                    // break;
                                }


                            }
                        }
                        // else {
                        //     eachCalculationArray.push(previousID - currentID);
                        //     if ((currentID > 52 && currentID <= 54) || (previousID > 52 && previousID <= 54)) {
                        //         continue;
                        //     }
                        //     else if (currentID - previousID == cardToPush) {
                        //         let removedCard;

                        //         if (nextID != 0 && currentID - previousID > nextID - currentID) {
                        //             removedCard = document.getElementById("card" + previousID);
                        //             console.log("Removed Card", removedCard);
                        //             document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                        //             removedCard.style.marginLeft = (parseFloat(getComputedStyle(removedCard).marginLeft) - parseFloat(getComputedStyle(removedCard).marginLeft)) + "px";
                        //             document.getElementById("processArea2").appendChild(removedCard);
                        //             // removedCard.style.marginLeft = "0px";
                        //         }
                        //         else {
                        //             removedCard = document.getElementById("card" + previousID);
                        //             console.log("Removed Card", removedCard);
                        //             document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                        //             removedCard.style.marginLeft = (parseFloat(getComputedStyle(removedCard).marginLeft) - parseFloat(getComputedStyle(removedCard).marginLeft)) + "px";
                        //             document.getElementById("processArea2").appendChild(removedCard);
                        //             // removedCard.style.marginLeft = "0px";
                        //         }

                        //         document.getElementById("computerSuit" + computerSuits).style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits)).width) - 60 + "px";


                        //         for (let r = suitsInnerCards + 1; r < computerSuitChilds.length; r++) {
                        //             computerSuitChilds[r].style.marginLeft = (r - 1) * 60 + "px";
                        //         }
                        //     }
                        // }
                    }

                }
            }
        }, 3000);


        setTimeout(() => {
            for (let u = 1; u <= computer.children.length; u++) {
                let parent = document.getElementById("computerSuit" + u);
                let sortingArray = Array.from(parent.children);

                let childrenIdWithElements = sortingArray.map(card => ({
                    element: card,
                    idNumber: parseInt(card.id.replace("card", ""))
                }));

                childrenIdWithElements.sort((a, b) => a.idNumber - b.idNumber);

                while (parent.firstChild) {
                    parent.removeChild(parent.firstChild);
                }

                childrenIdWithElements.forEach((item, index) => {
                    item.element.style.marginLeft = (index * 60) + "px";
                    parent.appendChild(item.element);
                });
            }

        }, 4000);

        setTimeout(() => {
            cardFinalValidationComputer();
            player1LogoName1.style.backgroundImage = "url('computerLogo.jpeg')";

        }, 6000);

    }


    dropButton.addEventListener("click", function () {
        var input = prompt("Are you sure you want drop the card(y/n)");
        if (input == "y") {
            location.reload();
        }
        countForPenalty += 40;
    });


}