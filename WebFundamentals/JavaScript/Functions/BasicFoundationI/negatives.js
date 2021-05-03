function negativestozeros(array) {
	for (let index = 0; index < array.length; index++) {
		if (array[index] < 0) {
			array[index] = 0;
		}
	}
	return array;
}

var array = [1, 5, 10, -2];
console.log(negativestozeros(array));
