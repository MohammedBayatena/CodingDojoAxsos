function square_array(array) {
	for (let index = 0; index < array.length; index++) {
		array[index] *= array[index];
	}
	return array;
}
var array = [1, 5, 10, -2];
console.log(square_array(array));
