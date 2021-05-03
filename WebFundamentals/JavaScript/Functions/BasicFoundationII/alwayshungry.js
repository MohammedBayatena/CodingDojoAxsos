function alwayshungry(array, word) {
	var flag = 1;
	for (let index = 0; index < array.length; index++) {
		if (array[index].localeCompare(word) === 0) {
			console.log("yummy");
			flag = 0;
		}
	}
	if (flag) {
		console.log("I'm hungry");
	}
}

array = ["notfood", "againnotfood", "food", "XDthatsfun","food3","food2"];
var wordtosearchfor = "food";
alwayshungry(array, "food");
