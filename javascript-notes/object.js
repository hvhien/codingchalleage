// decalre an object

let person={
    name:"hien",
    age:24
}

// bracket notation
let propertyName=['name'];
console.log(person[propertyName]);
person.job="IT"
propertyName.push("job")
console.log(person[propertyName]);

// object method

let student = {
    name:"hien",
    age: 24,
    greet: (name)=>{
        console.log(`greeting from ${name}`);
    }
}

for(let key in person){
    console.log(`${key}: ${person[key]}`);
}

// JSON (Javascript object anotation)

// 1 kind of data, often used to send data between a server and a web app


//convert object to json
let jsonStr=JSON.stringify(person);
// '{"name":"hien","age":24,"job":"IT"}'
let newPerson=JSON.parse(jsonStr);
// {name: 'hien', age: 24, job: 'IT'}