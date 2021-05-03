function incrementseconds(array) {
	for (let index = 1; index < array.length; index += 2) {
		array[index] += 1;
	}
    return array;
}

var array = [1, 0, 2, 0, 3, 0, 4, 5];
console.log(incrementseconds(array));
