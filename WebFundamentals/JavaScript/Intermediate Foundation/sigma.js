function sigma(num){
    var sum=0;
    for (let number = 0; number <= num; number++) {
        sum+=number;
    }
    return sum;
}
console.log(sigma(5));