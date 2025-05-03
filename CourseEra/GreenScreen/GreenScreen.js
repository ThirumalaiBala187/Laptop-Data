let fgImageData;
let bgImageData;

let fgCanvas = document.getElementById("fgCanvas");
let bgCanvas = document.getElementById("bgCanvas");
let finalCanvas = document.getElementById("finalCanvas");
let finalImage;

let context1 = fgCanvas.getContext("2d");
let context2 = bgCanvas.getContext("2d");
let context3 = finalCanvas.getContext("2d");


let image1=document.getElementById("fgImage");
let image2=document.getElementById("bgImage");


document.getElementById("fgImage").addEventListener('change',function upload(){
    fgImageData = new SimpleImage(image1);
    fgImageData.drawTo(fgCanvas);
});

document.getElementById("bgImage").addEventListener('change',function upload(){
    bgImageData = new SimpleImage(image2);
    bgImageData.drawTo(bgCanvas);
});

document.getElementById("applyFilter").addEventListener('click', function greenScreen(){
    let finalImage = fgImageData;
    for(let pixel of fgImageData.values()){
        let red = pixel.getRed();
        let green = pixel.getGreen();
        let blue = pixel.getBlue();

        if((blue+red)<=green){
            let bgPixel = bgImageData.getPixel(pixel.x,pixel.y);
            finalImage.setPixel(pixel.x,pixel.y,bgPixel);
        }
    }
    finalImage.drawTo(finalCanvas);
});

document.getElementById("clearCanvas").addEventListener("click", function clear(){
    context3.clearRect(0,0, finalCanvas.width, finalCanvas.height);
    context1.clearRect(0,0, fgCanvas.width, fgCanvas.height);
    context2.clearRect(0,0, bgCanvas.width, bgCanvas.height);
    image1.value = "";
    image2.value = "";

});