//prototype
var arr = ["a","b","c"];
console.log(arr.length);

Array.prototype.size = function(){
	return this.length;
};
/*arr.size = function(){
	return this.length;
}*/
console.log(arr.size());