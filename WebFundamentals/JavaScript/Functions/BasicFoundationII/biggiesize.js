function positivetostring(array, string) {
	for (let index = 0; index < array.length; index++) {
		if (array[index] > 0) {
			array[index] = string;
		}
	}
	return array;
}
var array = [-1, 3, 5, -5];
console.log(positivetostring(array, "big"));
