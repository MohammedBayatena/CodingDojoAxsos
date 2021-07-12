/*
//Speed Up Code for primes
Number.prototype.isPrime = function() {
    for( let i=2; i<=Math.sqrt(this); i++ ) {
        if( this % i === 0 ) {
            return false;
        }
    }
    return true;
}
//0.355 second vs 47.6 seconds
const { performance } = require('perf_hooks');
const start = performance.now();
let primeCount = 0;
let num = 2; // for math reasons, 1 is considered prime
while( primeCount < 1e4 ) {
    if( num.isPrime() ) {
        primeCount++;
    }
    num++;
}
console.log(`The 10,000th prime number is ${num-1}`);
console.log(`This took ${performance.now() - start} milliseconds to run`);
*/

/*
//Recursive vs Iterative 
const { performance } = require('perf_hooks');
// recursive
function rFib( n ) {
    if ( n < 2 ) {
        return n;
    }
    return rFib( n-1 ) + rFib( n-2 );
}
// iterative
function iFib( n ) {
    const vals = [ 0, 1 ];
    while(vals.length-1 < n) {
        let len = vals.length;
        vals.push( vals[len-1] + vals[len-2] );
    }
    return vals[n];
}
let start = performance.now();
rFib(20);
console.log(`Recursive took ${performance.now() - start} milliseconds to run`);
start = performance.now();
iFib(20);
console.log(`Iterative took ${performance.now() - start} milliseconds to run`);
*/

// Faster String reverse .23 vs .53

/*
const {
    performance
} = require('perf_hooks');
const story = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Provident culpa nihil repellat nulla laboriosam maxime, quia aliquam ipsam reprehenderit delectus reiciendis molestias assumenda aut fugit tempore laudantium tempora aspernatur? Repellendus consequatur expedita doloribus soluta cupiditate quae fugit! Aliquid, repellat animi, illum molestias maiores, laboriosam vero impedit iusto mollitia optio labore asperiores!";
let start = performance.now();
const reversed1 =  [...story].reverse().join('');
console.log(`Reverse took ${performance.now() - start} milliseconds to run`);
console.log(reversed1);
*/