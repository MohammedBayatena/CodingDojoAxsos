function sort(array) {
	//Bubble sort
	for (let index = 0; index < array.length; index++) {
		for (let index2 = 0; index2 < array.length; index2++) {
			if (array[index2] > array[index]) {
				temp = array[index];
				array[index] = array[index2];
				array[index2] = temp;
			}
		}
	}
	return array;
}

function secondtolast(array) {
	if (array.length < 2) {
		return null;
	} else {
		return array[array.length - 2];
	}
}

var array = [42, 1, 4, 3.14, 7];
console.log(secondtolast(sort(array)));
