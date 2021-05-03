function evensNodds(array, windowsize) {
	var countodd = 0;
	var counteven = 0;
	for (let i = 0; i < array.length; i += windowsize) {
		for (let index = 0; index < windowsize; index++) {
			if (i + index > array.length - 1) {
				break;
			} else {
				if (array[i + index] % 2 == 0) {
					counteven++;
					countodd = 0;
				} else {
					countodd++;
					counteven = 0;
				}
				if (counteven == windowsize) {
					console.log("Even more so!");
					counteven = 0;
				} else if (countodd == windowsize) {
					console.log("That's odd!");
					countodd = 0;
				}
			}
		}
	}
}
var array = [-1, 1, 1, 1, 1, 1, 1];
evensNodds(array, 3);
