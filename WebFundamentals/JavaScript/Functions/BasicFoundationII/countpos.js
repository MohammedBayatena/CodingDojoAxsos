function count_greater_than_number(array, number) {
	var count = 0;
	for (let index = 0; index < array.length; index++) {
		if (array[index] > number) {
			count++;
		}
	}
	return count;
}

function countpos(array) {
	array[array.length - 1] = count_greater_than_number(array, 0);
	return array;
}

var array = [-1, 1, 1, 1];
console.log(countpos(array));
