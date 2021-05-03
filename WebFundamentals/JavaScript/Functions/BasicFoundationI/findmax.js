function findmax(array) {
	max = array[0];
	for (let index = 1; index < array.length; index++) {
		if (array[index] > max) {
			max = array[index];
		}
	}
	return max;
}
var array = [-3, 3, 5, 7];
console.log("Max is: ", findmax(array));
