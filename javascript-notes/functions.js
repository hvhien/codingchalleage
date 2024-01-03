// Functions
// concep: for reusable

// declaring a function
function someLogic(...someParameters){
    // with parameters like above, that mean no limit for input number
}


// function expression:
const greet = function(name){
    console.log(`greet function for a variable with para ${name}`);
}

//Arrow functions:
// was instroduced in ES6, arrow function provide a concise syntax for writing function

const greet1= (name)=>{
    console.log(`greeting with arrow function with ${name}`);
}

// callback function

function fetchData(callback){
    //asynchronous operation
    setTimeout(()=>{
        const data='fetched data';
        callback(data);
    },1000);
}
fetchData((result)=>{
    console.log(result);// print fetched data 
})