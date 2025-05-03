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
        pTag1.style.fontSize = "30px";
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
    pTag.style.fontSize = "45px";
    pTag.style.textDecoration = "underline"
    pTag.style.color = "red";
    pTag.innerText = "Instructions :";

    var pTag1 = document.createElement("p");
    pTag1.style.fontWeight = "normal";
    pTag1.classList.add("pTagClass");
    document.getElementById("instructionsParagraph").appendChild(pTag1);
    pTag1.style.fontSize = "30px";
    pTag1.style.textAlign = "left";
    setTimeout(() => {
        pTag1.innerText += "1. Objective :\n\nForm valid sets and sequences using all your cards. A sequence is three or more cards in a row of the same suit, and a set is three or four cards of the same rank from different suits.";
        pTag1.innerText += "\n\n2. Number of Rounds :\n\nThe game consists of 5 rounds. The player with the lowest total points at the end of all rounds wins.";
        pTag1.innerText += "\n\n3. GamePlay : \n\n- Each player is dealt a set number of cards.\n- Players take turns drawing from the deck or discard pile and discarding one \t card.\n- Aim to arrange your cards into valid sets and sequences.";
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

    }, 300);


}

function loading() {
    while (document.getElementById("bg").firstChild) {
        document.getElementById("bg").removeChild(document.getElementById("bg").firstChild);
    }

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
    }, 300);

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

    let wildJokerId = null;
    let wildJokerNumber = 0;
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

                selectedCards.add(randomCardNum);
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
                }
                else {
                    clearInterval(cardsSplitting);
                    console.log(cardNumbersToSortP);
                    console.log(cardNumbersToSortC);

                    var whileLoopVariable = 0;
                    var wildJoker = null;

                    while (whileLoopVariable == 0) {
                        randomCardNum = Math.floor(Math.random() * childCards.length) + 1;

                        if (!selectedCards.has(randomCardNum) && randomCardNum < (document.getElementById("processArea1").children.length - 1)) {
                            var cardToRemove = document.getElementById("card" + randomCardNum);
                            selectedCards.add(randomCardNum);
                            console.log("Card to remove from joker", cardToRemove)
                            if (cardToRemove) {
                                document.getElementById("processArea1").removeChild(cardToRemove);
                            }
                            cardChosenImg = document.createElement("img");
                            cardChosenImg.src = `RummyCards/cards${randomCardNum}.png`;
                            cardChosenImg.classList.add("cardSize");
                            cardChosenImg.id = "card" + randomCardNum;

                            if (!wildJoker) {
                                wildJoker = cardChosenImg;
                                wildJokerId = wildJoker.id;
                                wildJokerNumber = parseInt((wildJoker.id).replace("card", ""));
                                wildJoker.style.transform = "rotate(90deg) translateY(80px)";
                                document.getElementById("processArea1").prepend(wildJoker);
                                randomCardNum = Math.floor(Math.random() * childCards.length) + 1;
                                break;
                            }

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
    var sortId = 0;


    document.getElementById("sort").addEventListener("click", function () {

        if (sortId == 0) {
            sortId = 1;
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
            var selectedCardParent = null;
            var selectedCardGroup;
            var lastClickedCard = null;


            //Card to make translate on Y when clicked
            var clickedCardVar = 0;
            var cardsToMove = document.querySelectorAll(".cardSize");
            cardsToMove.forEach(card => {
                card.addEventListener("click", function (event) {
                    if (lastClickedCard && lastClickedCard != card) {
                        lastClickedCard.style.transform = "translateY(0px)";
                        clickedCardVar = 0;
                    }
                    if (clickedCardVar == 0) {
                        card.style.transform = "translateY(-50px)";
                        lastClickedCard = card;
                        selectedCard = event.target;
                        selectedCardParent = selectedCard.parentNode.id;
                        console.log(selectedCardParent);
                        selectedCardGroup = Array.from(document.getElementById(selectedCardParent).children);
                        clickedCardVar++;
                    }
                    else if (lastClickedCard == card) {
                        card.style.transform = "translateY(0px)";
                        clickedCardVar = 0;
                        lastClickedCard = null;
                    }
                    // console.log(selectedCardGroup);
                });

            });


            document.getElementById("sort").style.filter = "blur(1px)";


            //Cards to move wqhen the specific keys are pressed

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
                    document.getElementById("playerSuit1").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit1")).width) + 60) + "px";
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit1").children.length - 1) * 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";

                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if (event.key == "2" && selectedCard) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("playerSuit2").appendChild(selectedCard);
                    document.getElementById("playerSuit2").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit2")).width) + 60) + "px";
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit2").children.length - 1) * 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if (event.key == "3" && selectedCard) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("playerSuit3").appendChild(selectedCard);
                    document.getElementById("playerSuit3").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit3")).width) + 60) + "px";
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit3").children.length - 1) * 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if (event.key == "4" && selectedCard) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("playerSuit4").appendChild(selectedCard);
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit4").children.length - 1) * 60) + "px";
                    document.getElementById("playerSuit4").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit4")).width) + 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if (event.key == "5" && selectedCard) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("playerSuit5").appendChild(selectedCard);
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit5").children.length - 1) * 60) + "px";
                    document.getElementById("playerSuit5").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit5")).width) + 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if (event.key == "6" && selectedCard) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("playerSuit6").appendChild(selectedCard);
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = ((document.getElementById("playerSuit6").children.length - 1) * 60) + "px";
                    document.getElementById("playerSuit6").style.width = (parseFloat(getComputedStyle(document.getElementById("playerSuit6")).width) + 60) + "px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";

                }

                else if ((event.key == "P" && selectedCard) || (event.key == "p" && selectedCard)) {
                    whoseTurn.innerText = "Computer's Turn";
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("processArea2").appendChild(selectedCard);

                    selectedCard.style.marginLeft = "0px";
                    selectedCard.style.transform = "translateY(0px)";

                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }

                    document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                    oneCardDrag = 0;

                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }

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
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    // document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                    winningCheck();

                }

                else if ((event.key == "G" && selectedCard) || (event.key == "g" && selectedCard)) {
                    document.getElementById(selectedCardParent).removeChild(selectedCard);
                    document.getElementById("processArea3").appendChild(selectedCard);
                    // console.log(document.getElementById("playerSuit1").children.length)
                    selectedCard.style.marginLeft = "0px";
                    selectedCard.style.transform = "translateY(0px)";
                    for (let r = selectedCardGroup.indexOf(selectedCard) + 1; r < selectedCardGroup.length; r++) {
                        selectedCardGroup[r].style.marginLeft = ((r - 1) * 60) + "px";
                    }
                    if (document.getElementById(selectedCardParent).children.length == 0) {
                        document.getElementById("player1").removeChild(document.getElementById(selectedCardParent));
                        player1.style.width = (parseFloat(getComputedStyle(player1).width) - 150) + "px";
                    }
                    // document.getElementById(selectedCardParent).style.width = parseFloat(getComputedStyle(document.getElementById(selectedCardParent)).width) - 60 + "px";
                    setTimeout(()=>{
                        winningCheck1()
                    },2000)

                }


            });

        };
    })


    //To create a new group for suits
    newGroupButton.addEventListener("click", function () {
        player1.style.width = (player1.offsetWidth + 240) + "px";
        var suits = document.createElement("div");
        suits.id = "playerSuit" + ((player1.children.length) + 1);
        suits.style.width = "90px"
        suits.classList.add("suitsToSort", "flex");
        player1.appendChild(suits);
        console.log(suits.id);
        playerSuitId++;
    });

    //To drop and end the game

    dropButton.addEventListener("click", function () {
        var input = prompt("Are you sure you want drop the card(y/n)");
        if (input == "y") {
            location.reload();
        }
        countForPenalty += 40;
    });

    //To remove the elements last suit if not needed
    player1.addEventListener("click", function (event) {
        let clickedSuit = event.target;
        if (player1.lastElementChild == clickedSuit) {
            player1.removeChild(player1.lastElementChild);
            player1.style.width = (player1.offsetWidth - 150) + "px";
            playerSuitId--;
        }
    });

    var cardsToDrag = document.getElementById("player1");
    var turnCal = 0;
    oneCardDrag = 0;


    //To take new card from the deck

    document.getElementById("processArea1").addEventListener("click", function (event) {
        let remainingCardsInTheDeck = Array.from(document.getElementById("processArea1").children);
        console.log("Remaining cards in the deck", remainingCardsInTheDeck)
        event.target.style.transform = "translateY(0px)";
        if (oneCardDrag == 0) {
            oneCardDrag++;
            console.log(player1.children.length, "Suits count");

            // console.log(document.getElementById("processArea1").children.length);
            randomCardNum = Math.floor(Math.random() * (remainingCardsInTheDeck.length-1)) + 1;
            console.log("Selected numbers from card to check:", randomCardNum);

            if (randomCardNum < document.getElementById("processArea1").children.length-1) {
                console.log("if")
                console.log("My number:", randomCardNum);
                console.log("My cards:", remainingCardsInTheDeck[randomCardNum])
                console.log("My cards id:", remainingCardsInTheDeck[randomCardNum].id);

                suits = document.createElement("div");
                suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
                player1.style.width = (player1.offsetWidth + 150) + "px";
                suits.style.width = "150px"
                suits.classList.add("suitsToSort", "flex");
                player1.appendChild(suits);
                console.log("Suit numbered:",suits.id);
                console.log(remainingCardsInTheDeck[randomCardNum]);
                suits.appendChild(remainingCardsInTheDeck[randomCardNum]);
                selectedCards.add(randomCardNum);
            }

        }

        if (document.getElementById("processArea1").children.length == 2) {
            while (document.getElementById("processArea2").firstChild) {
                document.getElementById("processArea1").appendChild((document.getElementById("processArea2").firstChild))
                document.getElementById("processArea2").removeChild((document.getElementById("processArea2").firstChild));
            }
        }

    });



    //To take a new card from previous cards
    document.getElementById("processArea2").addEventListener("click", function (event) {
        event.target.style.transform = "translateY(0px)";
        if (oneCardDrag == 0) {
            oneCardDrag++;
            console.log(player1.children.length, "Suits count");
            let cardIdToAppend = parseInt((document.getElementById("processArea2").lastChild.id).replace("card", ""));
            console.log("Recent card Id", cardIdToAppend)
            let cardToAppend = document.getElementById("processArea2").lastChild;

            suits = document.createElement("div");
            suits.id = "playerSuit" + (document.getElementById("player1").children.length + 1);
            player1.style.width = (player1.offsetWidth + 150) + "px";
            suits.style.width = "150px"
            suits.classList.add("suitsToSort", "flex");
            player1.appendChild(suits);
            console.log("Suits created by taking new cards:", suits.id);
            console.log("Cards taken new cards:", cardToAppend.id);
            cardToAppend.style.marginLeft = "0px";
            suits.appendChild(cardToAppend);

        }
    });


    //To make the computer to take a new card
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
        let cardIdToAppend = parseInt(((remainingCardsInTheDeck[randomCardNum]).id).replace("card", ""));
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
                suits.appendChild(remainingCardsInTheDeck[randomCardNum]);

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
                if (computerSuitChilds.length == 1 && parseInt((computerSuitChilds[0].id).replace("card", "")) <= 52 && parseInt((computerSuitChilds[0].id).replace("card", "")) == wildJokerNumber) {
                    let cardToRemove = document.getElementById("computerSuit" + computerSuits).firstChild;
                    document.getElementById("computerSuit" + computerSuits).removeChild(document.getElementById("computerSuit" + computerSuits).firstChild);
                    cardToRemove.style.marginLeft = 0 + "px";
                    (document.getElementById("computerSuit" + computerSuits).firstChild).style.marginLeft = (parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits).firstChild).marginLeft) - parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits).firstChild).marginLeft)) + "px";
                    (document.getElementById("computerSuit" + computerSuits).firstChild).style.opacity = "100%";
                    document.getElementById("processArea2").appendChild(cardToRemove);
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
                                    removedCard.style.marginLeft = 0 + "px";
                                    removedCard.style.position = "absolute";
                                    console.log("Removed Card", removedCard);
                                    document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                                    document.getElementById("processArea2").appendChild(removedCard);
                                    removedCard.style.opacity = "100%";
                                    document.getElementById("computerSuit" + computerSuits).style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits)).width) - 60 + "px";


                                    for (let r = suitsInnerCards + 1; r < computerSuitChilds.length; r++) {
                                        computerSuitChilds[r].style.marginLeft = (r - 1) * 60 + "px";
                                    }
                                }
                                else {
                                    removedCard = document.getElementById("card" + nextID);
                                    console.log("Removed Card", removedCard);
                                    removedCard.style.marginLeft = (parseFloat(getComputedStyle(removedCard).marginLeft) - parseFloat(getComputedStyle(removedCard).marginLeft)) + "px";
                                    removedCard.style.marginLeft = 0 + "px";;
                                    removedCard.style.position = "absolute";
                                    removedCard.style.opacity = "100%";
                                    document.getElementById("computerSuit" + computerSuits).removeChild(removedCard);
                                    document.getElementById("processArea2").appendChild(removedCard);
                                    document.getElementById("computerSuit" + computerSuits).style.width = parseFloat(getComputedStyle(document.getElementById("computerSuit" + computerSuits)).width) - 60 + "px";

                                    removedCard.style.marginLeft = "0px";

                                    for (let r = suitsInnerCards + 1; r < computerSuitChilds.length; r++) {
                                        computerSuitChilds[r].style.marginLeft = (r - 1) * 60 + "px";
                                    }
                                }
                            }
                        }

                    }

                }
            }

            whoseTurn.innerText = "Your Turn";
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
            winningCheckComputer();
        }, 6000);

    }

    var countForPenalty = 0;

    function pureSequenceValidation(arrayToValidate) {
        for (let childId = 0; childId < (arrayToValidate.length) - 1; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            let nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));

            if (currentId == 53 || currentId == 54 || nextId == 53 || nextId == 54) {
                return false
            }
            else if (nextId - currentId != 1) {
                return false
            }
        }
        return true;
    }


    function impureSequenceValidation(arrayToValidate) {
        for (let childId = 0; childId < (arrayToValidate.length) - 1; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));
            if (currentId == 53 || currentId == 54 || nextId == 53 || nextId == 54 || currentId == wildJokerNumber || nextId == wildJokerNumber) {
                continue;
            }
            if (nextId - currentId != 1) {
                return false;
            }
        }
        return true;
    }

    function setAValidation(arrayToValidate) {

        for (let childId = 0; childId < (arrayToValidate.length) - 1; childId++) {
            var currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));

            if (currentId == 53 || currentId == 54 || nextId == 53 || nextId == 54 || currentId == wildJokerNumber || nextId == wildJokerNumber) {
                continue;
            }
            if (nextId - currentId != 13) {
                return false;
            }
        }
        return true;
    }

    function setBValidation(arrayToValidate) {


        for (let childId = 0; childId < (arrayToValidate.length) - 1; childId++) {
            let currentId = parseInt((arrayToValidate[childId].id).replace("card", ""));
            var nextId = parseInt((arrayToValidate[childId + 1].id).replace("card", ""));

            if (currentId == 53 || currentId == 54 || nextId == 53 || nextId == 54 || currentId == wildJokerNumber || nextId == wildJokerNumber) {
                continue;
            }
            if (nextId - currentId != 13) {
                return false;
            }
        }
        return true;
    }


    var pureCheckVariable = false;

    function winningCheck() {

        var possibleRules = [[4, 3, 3, 3], [3, 4, 3, 3], [3, 3, 4, 3], [3, 3, 3, 4]];
        let childrenCount = player1.children;
        var correctOrderMatch;
        var ruleNumber = 0;

        if (childrenCount.length == 4) {

            for (let rule of possibleRules) {
                let valid = true;

                for (let rules = 0; rules < possibleRules.length; rules++) {
                    ruleNumber++;
                    if (childrenCount[rules].length != rule[rules]) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    correctOrderMatch = rule;
                    break;
                }
            }

            if (correctOrderMatch) {
                var allValidCards = true;

                for (let r = 0; r < correctOrderMatch.length; r++) {
                    let currentContainer = childrenCount[r];
                    let childInCurrentContainer = Array.from(currentContainer.children);

                    let pureSequenceCheck = false;
                    let impureSequenceCheck = false;
                    let setASequenceCheck = false;
                    let setBSequenceCheck = false;

                    pureSequenceCheck = pureSequenceValidation(childInCurrentContainer);
                    impureSequenceCheck = impureSequenceValidation(childInCurrentContainer);
                    setASequenceCheck = setAValidation(childInCurrentContainer);
                    setBSequenceCheck = setBValidation(childInCurrentContainer);

                    if (pureSequenceCheck) {
                        pureCheckVariable = true;
                    }

                    if (!pureSequenceCheck && !impureSequenceCheck && !setASequenceCheck && !setBSequenceCheck) {
                        allValidCards = false;
                        break;
                    }

                }
                if (allValidCards == true && pureCheckVariable == true) {
                    var img = document.createElement("img");
                    img.src = "winner.jpeg";
                    img.classList.add("finalImg");
                    while (document.getElementById("backgroundTable").firstChild) {
                        document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                    }
                    document.getElementById("backgroundTable").appendChild(img);
                }
                else {
                    var finalImgLoser = document.createElement("img");
                    finalImgLoser.src = "loser.jpg";
                    finalImgLoser.classList.add("finalImg");
                    while (document.getElementById("backgroundTable").firstChild) {
                        document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                    }
                    document.getElementById("backgroundTable").appendChild(finalImgLoser);
                }
            }
            else {
                var finalImgLoser = document.createElement("img");
                finalImgLoser.src = "loser.jpg";
                finalImgLoser.classList.add("finalImg");
                while (document.getElementById("backgroundTable").firstChild) {
                    document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                }
                document.getElementById("backgroundTable").appendChild(finalImgLoser);
            }
        }
    }




    function winningCheckComputer() {

        var possibleRules = [[4, 3, 3, 3], [3, 4, 3, 3], [3, 3, 4, 3], [3, 3, 3, 4]];
        let childrenCount = computer.children;
        var correctOrderMatch;
        var ruleNumber = 0;

        if (childrenCount.length == 4) {

            for (let ruleTaken of possibleRules) {
                let valid = true;

                for (let rules = 0; rules < possibleRules.length; rules++) {
                    ruleNumber++;
                    if (childrenCount[rules].length != ruleTaken[rules]) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    correctOrderMatch = rule;
                    break;
                }
            }

            if (correctOrderMatch) {
                var allValidCards = true;

                for (let r = 0; r < correctOrderMatch.length; r++) {
                    let currentContainer = childrenCount[r];
                    let childInCurrentContainer = Array.from(currentContainer.children);

                    let pureSequenceCheck = false;
                    let impureSequenceCheck = false;
                    let setASequenceCheck = false;
                    let setBSequenceCheck = false;

                    pureSequenceCheck = pureSequenceValidation(childInCurrentContainer);
                    impureSequenceCheck = impureSequenceValidation(childInCurrentContainer);
                    setASequenceCheck = setAValidation(childInCurrentContainer);
                    setBSequenceCheck = setBValidation(childInCurrentContainer);

                    if (pureSequenceCheck) {
                        pureCheckVariable = true;
                    }

                    if (!pureSequenceCheck && !impureSequenceCheck && !setASequenceCheck && !setBSequenceCheck) {
                        allValidCards = false;
                        break;
                    }

                }
                if (allValidCards == true && pureCheckVariable == true) {
                    var finalImgLoser = document.createElement("img");
                    finalImgLoser.src = "loser.jpg";
                    finalImgLoser.classList.add("finalImg");
                    while (document.getElementById("backgroundTable").firstChild) {
                        document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
                    }
                    document.getElementById("backgroundTable").appendChild(finalImgLoser);
                }
            }
        }
    }






























































































































































































































































































    function winningCheck1() {
        var img = document.createElement("img");
        img.src = "winner.jpeg";
        img.classList.add("finalImg");
        while (document.getElementById("backgroundTable").firstChild) {
            document.getElementById("backgroundTable").removeChild(document.getElementById("backgroundTable").firstChild);
        }
        document.getElementById("backgroundTable").appendChild(img);
    }



}
