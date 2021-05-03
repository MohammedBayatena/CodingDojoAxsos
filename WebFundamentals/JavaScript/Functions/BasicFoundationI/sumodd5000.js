function get_odds_sum_1_to_number(number) {
	var sum=0;
	for (let i = 1; i <= number; i+=2) {
		sum+=i;
	}
	return sum;
}
var sum = get_odds_sum_1_to_number(5000);
console.log(sum);
