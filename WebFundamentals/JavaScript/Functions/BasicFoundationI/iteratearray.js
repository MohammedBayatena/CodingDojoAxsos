var array1 = [1,2,5];
var array2 = [-5, 2, 5, 12];


function sumarray(array) {
	var sum=0;
    for (let i = 0; i < array.length; i++) {
		sum+= array[i];
	}
    return sum;
}
console.log("Sum is",sumarray(array1));
console.log("Sum is",sumarray(array2));
