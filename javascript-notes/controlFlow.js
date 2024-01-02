// Control Flow
// 1. Conditional statements
let x=10;
if(x>5){
    console.log('x is greater than 5');
}else{
    console.log('x not greater than 5');
}


// 2.Loop

for(let i=0;i<5;i++){
    if(i===1){
        continue; //skip for i=1
    }
    if(i===3){
        break;// break loop with i=3
    }
    console.log(i);
}

// while loop

let i=0;
while(i<5){
    console.log(i);
    i++;
}

// do-while
let j=0;
do{
    j++;
    console.log('some thing');
}while(j<5);
