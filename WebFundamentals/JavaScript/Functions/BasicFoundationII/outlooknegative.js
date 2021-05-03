function negativesAdvnaced(array) {
	for (let index = 0; index < array.length; index++) {
		if (array[index] > 0) {
			array[index] *= -1;
		} else {
			continue;
		}
	}
	return array;
}
var array = [1, -3, 5, 9, -55];
console.log(negativesAdvnaced(array));
