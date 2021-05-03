function previouslen(array) {
	for (let index = array.length-1; index > 0; index--) {
		array[index] = array[index-1].length;
	}
    return array;
}
array=["hello", "dojo", "awesome","awesome","awesome"];
console.log(previouslen(array)); 
