var gridLength = 20;

var lattice = new Array(gridLength + 1);
for (var i = 0; i < lattice.length; i++) {
	lattice[i] = new Array(gridLength + 1);
}

for (var i = 0; i < gridLength + 1; i++) {
	lattice[i][0] = 1;
	lattice[0][i] = 1;
}

for (var i = 0; i < lattice.length; i++) {
	for (var j = 0; j < lattice[i].length; j++) {
		if (lattice[i][j] === undefined) {
			lattice[i][j] = lattice[i-1][j] + lattice[i][j-1];
		}
	}
}

console.log(lattice[gridLength][gridLength]);
