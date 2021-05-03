function printoneretanother(array) {
	console.log("second to last: ", array[array.length - 2]);
	for (let index = 0; index < array.length; index++) {
		if (array[index] % 2 != 0) {
			return array[index];
		}
	}
}

var array = [2, 8, 9, 2, 5, 6];
console.log("firstodd: ", printoneretanother(array));
