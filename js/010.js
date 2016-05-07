function sieve(cap) {
	var c = cap + 1
	var bools = [], res = [];
	while (c--)
		bools.push(true);
	bools[0] = 0;
	bools[1] = 0;

	for (var i = 0; i < bools.length; i++)
		if (bools[i]) {
			var cur = i * 2;
			while (cur < bools.length) {
				bools[cur] = 0;
				cur += i;
			}
		}

	for (var i = 0; i < bools.length; i++)
		if (bools[i])
			res.push(i);

	return res;
}

var primes = sieve(2000000);

sum = primes.reduce(function(prev, next) {
	return prev + next;
});

console.log(sum);
