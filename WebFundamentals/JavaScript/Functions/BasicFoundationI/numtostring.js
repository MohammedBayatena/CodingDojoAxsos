function negativesToString(array, string) {
	for (let index = 0; index < array.length; index++) {
		if (array[index] < 0) {
			array[index] = string;
		}
	}
	return array;
}
var array = [-1, -3, 2];
console.log(negativesToString(array, "Dojo"));
