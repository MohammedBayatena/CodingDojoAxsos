function factorial(num){
    var mul=1;
    for (let number = 1; number <= num; number++) {
        mul*=number;
    }
    return mul;
}
console.log(factorial(9));