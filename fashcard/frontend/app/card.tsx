import { useState,useEffect } from "react";

export default function Card(){
    const [data,setData]=useState(null);

    useEffect(()=>{
        fetch('http://localhost:8080/api/?status=0')
        .then((res)=> res.json())
        .then((data)=>{
            setData(data);
        });
    },[]);
    if(!data) return <h1>No data</h1>
    return (

    <div>
        <h1>{data.word}</h1>
    </div>)
    
}
