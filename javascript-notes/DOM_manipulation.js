/**
 * DOM manipulation
 * DOM (document object model) manipulation is a crucial aspect of web developmrent.
 * allow you to interact with and modify the structure,content and style of web document.
 * 
 * - DOM is a programming interface that represents the structure of an HTML or XML
 */

// accessing element
// 1. getElementById: retrieve an element by its unique ID attribute
let element =  document.getElementById("myElement");

// 2.getElementsByClassName: retrieve array element by their class name.
let elements = document.getElementsByClassName("myclass");

// 3.getElementsByTagName: retrieve array element by their tag name
let headLine1=document.getElementsByTagName("h1");

// add event listener
button.addEventListener("click",handleClik=(event)=>{alert("dump guy");});

