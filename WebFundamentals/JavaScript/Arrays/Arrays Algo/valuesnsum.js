var testArr = [6,3,5,1,2,4];
var sum=0;
console.log('Challenge 1');

for(let i=0 ; i < testArr.length; i++){
console.log('Number: ',testArr[i],'Sum: ',sum+=testArr[i]);
}
console.log('Challenge 2');
for(let i=0 ; i < testArr.length; i++){
testArr[i]*=i;
}
console.log('Edited Array ',testArr);
