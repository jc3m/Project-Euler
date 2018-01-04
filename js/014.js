var seqLens = {
	1: 1
};

function compute(i) {
	if (seqLens[i] != undefined) {
		return seqLens[i];
	}

	if (i % 2 === 0) {
		seqLens[i] = 1 + compute(i/2);
		return seqLens[i];
	}

	else {
		seqLens[i] = 1 + compute(3*i+1);
		return seqLens[i];
	}
}

var t, max = 0, maxVal;

for (var i = 1; i < 1000000; i++) {
	t = compute(i);
	if (t > max) {
		max = t;
		maxVal = i;
	}
}

console.log(max);
console.log(maxVal);
