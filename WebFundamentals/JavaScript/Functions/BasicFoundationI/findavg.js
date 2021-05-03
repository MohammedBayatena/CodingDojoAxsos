function find_average(array) {
	var sum = 0,
		avg = 0;
	for (let index = 0; index < array.length; index++) {
		sum += array[index];
	}
	avg = sum / array.length;
	return avg;
}
var array=[1,3,5,7,20]; 
console.log(find_average(array));
