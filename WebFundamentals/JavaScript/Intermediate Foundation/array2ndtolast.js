function secondtolast(array) {
    if (array.length < 2) {
        return null;
        
    }else{
        return array[array.length-2];
    }    
}
var array= [42, true, 4, "Liam", 7];
console.log(secondtolast(array));  