//example with var
function exampleVar(){
    if(true){
        var x=10;
    }
    console.log(x); // print 10, because var is function scope
}

//Example with let
function exampleLet(){
    if(true){
        let y=11;
        console.log(y); // print 11, because let is block-scoped
    }
    console.log(y); // print error: ReferenceError: y is not defined, as it's outside the block
}

//Example with const
function exampleConst(){
    const z=12;
    // z=13; error: TypeError: Assignment to constant variable
    console.log(z); // print 12 : block-scoped

    // some cases can reassigned value for constant variable
    // 1. type of variable is object
    const obj={key:"value"};
    obj.key="new value";
    console.log(obj.key); // print "new value"
    // 2. type of variable is array
    const array=[1,2,3];
    array[1]=10;
    console.log(array);// [1,10,3]
}

