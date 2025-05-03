let canvas = document.getElementById("display");
let input = document.getElementById("upload");
let result = document.getElementById("result");
let context1 = canvas.getContext("2d");
let context2 = result.getContext("2d");

let image;

input.addEventListener("change", function upload(){
    image = new SimpleImage(input);
    image.drawTo(canvas);
});

document.getElementById("button").addEventListener("click", function makeGrey(){
    for (let pixel of image.values()) {
        var avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3
        pixel.setRed(avg);
        pixel.setBlue(avg);
        pixel.setGreen(avg);
    }

    image.drawTo(result);
});


function clearCanvas(){
    context1.clearRect(0,0, canvas.width, canvas.height);
    context2.clearRect(0,0, result.width, result.height);
    input.value="";
}