function scalearray(array, num) {
	for (let index = 0; index < array.length; index++) {
		array[index] *= num;
	}
	return array;
}
var array = [1, 2, 3];
var num = 3;
console.log(scalearray(array, num));
