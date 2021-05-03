function find_average(array) {
	var sum = 0,
		avg = 0;
	for (let index = 0; index < array.length; index++) {
		sum += array[index];
	}
	avg = sum / array.length;
	return avg;
}

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

var array = [1, 5, 10, -2];
var result = [findmax(array), findmin(array), find_average(array)];
console.log(result);
