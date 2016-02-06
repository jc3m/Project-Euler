var a = 1
var b = 1
var total = 0
var next = undefined

while (b < 4000000) {
	if (b % 2 == 0) {
		total += b
	}
	next = a + b
	a = b
	b = next
}

console.log(total)