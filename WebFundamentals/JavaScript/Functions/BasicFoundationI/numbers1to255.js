function fillarraywithnumbers(number) {
	var arr = [];
	for (let i = 1; i <= number; i++) {
		arr.push(i);
	}
	return arr;
}
var array = fillarraywithnumbers(255);
console.log(array);
