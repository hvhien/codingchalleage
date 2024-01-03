// Operator and Expressions
// 1. Arithmetic operators:

function arithmeticOperators(a,b){
    let addition=a+b;
    let subtraction=a-b;
    let multiplication=a*b;
    let division=a/b;
    let modulus=a%b;
}

// 2. comparison operators:

function comparisonOperators(a,b){
    5==5 //true
    5=='5' //true
    5===5 //true
    5==='5' //false

    5>4 //true
    5<4 //false
    true && false //false
    true || false // true
    5!==5 //false
    5!=='5' //true
    5!='5'//false
    5!=5 //false
}

// 3.Assignment operators:
// Assigning value used (=), with short version (+=)(-=)(*=)(/=)

function assignmentOperators(a,b){
    let xxx=100;
    xxx=200;
    console.log(xxx);// print 200
    xxx +=5;
    console.log(xxx); // print 205

}

// 4.Increment and decrement

function Increment(){
    let x=100;
    console.log(x++);//print 100, because x variable will increment after print value
    console.log(x);// print 101
    // with another case
    console.log(++x); // print 102, because x variable incerment before print value

    // correponds with decrement
}

//5. String concatenation:
function concat(){
    let a="hello";
    let b="world";
    console.log(a+" "+b);// print :hello world
}

//6. template literals:

function templateLiteral(){
    let name="hien";
    let greeting=`hello ${name}`;
    console.log(greeting);//print :hello hien
}