"use client";
import React, { useState, useEffect } from "react";
import FlashCard from "./FlashCard";

const ApiDataComponent = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/?status=0");
        const jsonData = await response.json();
        setData(jsonData);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []); // The empty dependency array ensures the effect runs only once after the initial render

  return (
    <div className="card">
      <h1>Data from API:</h1>
      {data.length > 0 ? (
        <ul>
          {data.map((item, index) => (
            <li key={index}>
              <FlashCard data={item}/>
              {/* Add more fields if necessary */}
            </li>
          ))}
        </ul>
      ) : (
        <p>No data available</p>
      )}
    </div>
  );
};

export default ApiDataComponent;
