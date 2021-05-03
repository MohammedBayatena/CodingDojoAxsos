function get_evens_sum_1_to_number(number) {
	var sum = 0;
	for (let i = 0; i <= number; i += 2) {
		sum += i;
	}
	return sum;
}
var sum = get_evens_sum_1_to_number(1000);
console.log(sum);
