function swapvalues_atlocation_withlast(array,location) {
    var temp=array[location];
    array[location]=array[array.length-1];
    array[array.length-1] = temp;
    return array;
}
var array=[1,5,10,-2];
console.log(swapvalues_atlocation_withlast(array,0));