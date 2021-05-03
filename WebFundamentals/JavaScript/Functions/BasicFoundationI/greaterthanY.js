function count_greater_than_number(array, number) {
	var count = 0;
	for (let index = 0; index < array.length; index++) {
		if (array[index] > number) {
			count++;
		}
	}
    return count;
}

var array=[1, 3, 5, 7];
var Y=3;
console.log(count_greater_than_number(array,Y));
