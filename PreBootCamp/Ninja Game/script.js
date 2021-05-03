var leftValue = window.innerWidth / 2;
var topValue = window.innerHeight / 2;
function update() {
  document.getElementById("character").style.left = leftValue + "px";
  document.getElementById("character").style.top = topValue + "px";
}
var flag = 0;
document.onkeydown = function (e) {
  //console.log('e: ', e);
  //console.log('e.keyCode: ', e.keyCode);

  if (e.keyCode == 37) {
    // LEFT

    if (flag == 0) {
      document.getElementById("character").style.backgroundImage =
        "url(img/left1.png)";
      flag = 1;
    } else {
      document.getElementById("character").style.backgroundImage =
        "url(img/left2.png)";
      flag = 0;
    }

    if (!(leftValue < window.innerWidth / 2 - 500)) {
      leftValue = leftValue - 10;
    }
  } else if (e.keyCode == 39) {
    // RIGHT

    if (flag == 0) {
      document.getElementById("character").style.backgroundImage =
        "url(img/right1.png)";
      flag = 1;
    } else {
      document.getElementById("character").style.backgroundImage =
        "url(img/right2.png)";
      flag = 0;
    }
    if (!(leftValue > window.innerWidth / 2 + 500)) {
      leftValue = leftValue + 10;
    }
  } else if (e.keyCode == 40) {
    // DOWN

    if (flag == 0) {
      document.getElementById("character").style.backgroundImage =
        "url(img/down1.png)";
      flag = 1;
    } else {
      document.getElementById("character").style.backgroundImage =
        "url(img/down2.png)";
      flag = 0;
    }
    if (!(topValue > window.innerHeight / 2 + 500)) {
      topValue = topValue + 10;
    }
  } else if (e.keyCode == 38) {
    // UP

    if (flag == 0) {
      document.getElementById("character").style.backgroundImage =
        "url(img/top1.png)";
      flag = 1;
    } else {
      document.getElementById("character").style.backgroundImage =
        "url(img/top2.png)";
      flag = 0;
    }
    if (!(topValue < 0)) {
      topValue = topValue - 10;
    }
  }
  update();
};
