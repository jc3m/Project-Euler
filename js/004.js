function reverse(str) {
  var res = '';
  for (var i = str.length - 1; i >= 0; i--)
    res += str[i];
  return res;
}

function isPalindrome(num) {
  return String(num) == reverse(String(num));
}

var largest = 0;
var done = false;

for (var i = 999; i >= 100; i--) {
  if (i*i < largest)
    break;
  for (var j = i; j >= 100; j--) {
    var temp = i*j;
    if (isPalindrome(temp) && temp > largest)
      largest = temp;
  }
}

console.log(largest);
