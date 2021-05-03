function swaptowardcenter(array) {
	var temp;
	var reverseindex = 1;

	for (var i = 0; i < array.length / 2; i += 2) {
		temp = array[i];
		array[i] = array[array.length - 1 - i];
		array[array.length - 1 - i] = temp;
		reverseindex += 2;
	}
	console.log(array);
}
swaptowardcenter([1,2,3,4,5,6]);
