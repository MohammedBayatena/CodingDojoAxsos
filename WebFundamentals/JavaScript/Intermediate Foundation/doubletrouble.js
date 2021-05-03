function doubletrouble(array) {
	var newarray = [];
    originalarray=array.slice(0)
	for (let i = 0; i < originalarray.length; i++) {
		for (let j = 0; j < 2; j++) {
			newarray.push(originalarray[i]);
		}
	}
    return newarray;
}

var array=[4, "Ulysses", 42, false];
array=doubletrouble(array);
console.log(array);
