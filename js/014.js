var seqLens = [];
var l = 1000001
while (l--)
	seqLens.push(-1);

function calcSeq(val) {
	if (seqLens[val] != -1)
		return seqLens[val];
	if (val <= 1) {
		seqLens[val] = 1;
		return 1;
	}
}
