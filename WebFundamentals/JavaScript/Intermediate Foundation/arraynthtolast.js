function nthtolast(array, n) {
	if (array.length < n) {
		return null;
	} else {
		return array[array.length - n];
	}
}
var array = [5, 2, 3, 6, 4, 9, 7];
console.log(nthtolast(array, 3));
