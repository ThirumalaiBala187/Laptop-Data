document.addEventListener("visibilitychange", function(){
    if(document.hidden){
        alert("Tab Switching Detected");
    }
});
document.addEventListener('keypress', function(e) {
    if (e.key === "Escape" || e.keyCode === 27) {
        e.preventDefault();
        alert("Exiting fullscreen is not allowed during the exam.");
    }
});
navigator.mediaDevices.getUserMedia({audio : true})
.then(stream => {
    console.log("Microphone access granted : ",stream);
})
.catch(error => {
    console.log("Microphone access denied : " , error);
})


navigator.mediaDevices.getUserMedia({ video: true })
  .then(stream => {
    const videoElement = document.createElement("video");
    videoElement.srcObject = stream;
    videoElement.autoplay = true;
    document.body.appendChild(videoElement);
  })
  .catch(error => {
    console.error("Video access denied", error);
  });

document.getElementById('startExam').addEventListener('click', function() {
    if (document.documentElement.requestFullscreen) {
        document.documentElement.requestFullscreen();
    } else if (document.documentElement.mozRequestFullScreen) {
        document.documentElement.mozRequestFullScreen();
    } else if (document.documentElement.webkitRequestFullscreen) {
        document.documentElement.webkitRequestFullscreen();
    } else if (document.documentElement.msRequestFullscreen) {
        document.documentElement.msRequestFullscreen();
    }
});
document.addEventListener('fullscreenchange', function() {
    if (!document.fullscreenElement) {
        alert("You are no longer in fullscreen. Please re-enter fullscreen.");
        document.documentElement.requestFullscreen();
    }
});


document.addEventListener('webkitfullscreenchange', function() {
    if (!document.webkitFullscreenElement) {
        alert("You are no longer in fullscreen. Please re-enter fullscreen.");
        document.documentElement.webkitRequestFullscreen();
    }
});