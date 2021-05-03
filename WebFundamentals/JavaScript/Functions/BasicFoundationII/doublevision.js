function double(array) {
    mycopy=array.slice(0);
	for (let index = 0; index < mycopy.length; index++) {
		mycopy[index] *= 2;
	}
	return mycopy;
}
var array = [1, 2, 3];
var newArray = double(array);

console.log("original array: ", array);
console.log("doubled array", newArray);
