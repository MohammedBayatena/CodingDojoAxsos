function addseven(array) {
	newarr = array.slice(0);
	for (let index = 0; index < newarr.length; index++) {
		newarr[index] += 7;
	}
    return newarr;
}

var array=[1,2,3,1];
console.log("original array: ",array);
console.log("new array",addseven(array));
