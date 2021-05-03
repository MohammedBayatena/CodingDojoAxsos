function returnodds(array) {
	var oddsarr = [];
	for (let index = 0; index < array.length; index++) {
		if (array[index] % 2 != 0) {
			oddsarr.push(array[index]);
		}
	}
	return oddsarr;
}
//fill array with 50 items for testing
var array = [];
for (let i = 1; i < 50; i++) {
	array.push(i);
}
console.log(returnodds(array));
