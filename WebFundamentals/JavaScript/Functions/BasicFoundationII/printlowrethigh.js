function findmax(array) {
	max = array[0];
	for (let index = 1; index < array.length; index++) {
		if (array[index] > max) {
			max = array[index];
		}
	}
	return max;
}

function findmin(array) {
	min = array[0];
	for (let index = 1; index < array.length; index++) {
		if (array[index] < min) {
			min = array[index];
		}
	}
	return min;
}

function printlowRetHigh(array) {
	console.log(findmin(array));
	return findmax(array);
}

var array = [1, -5, 1000, -2];
var result = printlowRetHigh(array);
console.log(result);
