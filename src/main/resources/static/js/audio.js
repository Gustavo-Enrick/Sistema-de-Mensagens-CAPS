const audio = new Audio("/audio/hospital-monitor-151929.mp3");
const disableButton = () => {
    const btn = document.getElementsByClassName("btn-primary")[0];
    btn.remove();
    audio.play();
}