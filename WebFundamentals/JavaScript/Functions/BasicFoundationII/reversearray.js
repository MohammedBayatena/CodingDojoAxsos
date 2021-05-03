function reversearray(array) {

    for (let index = 0; index < array.length/2; index++) {
        var temp = array[index]; 
        array[index]=array[array.length-index-1];
        array[array.length-index-1]=temp;
    }
    return array;
}
var array=[3,1,6,4,2,6,5,3,9,2,5];
console.log( reversearray(array) );