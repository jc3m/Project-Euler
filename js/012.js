function divisors(num) {
	var cap = Math.sqrt(num);
	var res = 2;
	for (var i = 2; i < cap; i++) {
		if (num % i === 0) {
			res += 2;
		}
	}
	return res;
}

var x = 1;
var t = x;

while (divisors(t) < 500) {
	x++;
	t += x;
}

console.log(t);
