var arr = [];

for (var i = 1; i <= 20; i++) {
  var temp = i;
  for (var j = 0; j < arr.length; j++) {
    if (temp % arr[j] == 0) {
      temp = temp / arr[j];
    }
  }
  arr.push(temp);
}

res = 1;

for (var i = 0; i < arr.length; i++) {
  res *= arr[i];
}

console.log(res);
