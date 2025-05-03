var height=document.getElementById("height");
var width = document.getElementById("width");

var color = "black";
var radius = 50;
var isPainting = false;

var paintCanvas = document.getElementById("canvas");
var context = paintCanvas.getContext("2d");

document.getElementById("brushSize").addEventListener("input", function(e){
    radius = Number.parseInt(e.target.value);
});

document.getElementById("colorPicker").addEventListener("input", function(e){
    color=e.target.value;
});


function setHeight(e){
    if(e.key=="Enter"){
        if(height.value>= 750){
            paintCanvas.style.height="750px";
        }
        else{
            paintCanvas.style.height=height.value+"px";
        }
        height.value="";
    }
}

function setWidth(e){
    if(e.key=="Enter"){
        if(width.value>= 1500){
            paintCanvas.style.width="1500px";
        }
        else{
            paintCanvas.style.width=width.value+"px";
        }
        width.value="";
    }
}

paintCanvas.addEventListener("mousedown", function(e){
    isPainting = true;
    paintCircle(e.offsetX, e.offsetY);
});

paintCanvas.addEventListener("mouseup", function(){
    isPainting=false;
});

paintCanvas.addEventListener("mousemove", function(e){
    if(isPainting){
        paintCircle(e.offsetX, e.offsetY);
        context.beginPath();
    }
});

function paintCircle(x, y){
    context.beginPath();
    context.arc(x, y, radius, 0, Math.PI*2, true);
    context.fillStyle = color;
    context.fill();
}

function clearCanvas(){
    context.clearRect(0,0, paintCanvas.width, paintCanvas.height);
}


