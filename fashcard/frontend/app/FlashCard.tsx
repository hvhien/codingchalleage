"use client"

import { useState } from "react"

const FlashCard = ({data}) =>{
const [isFlipped,setFlipped] = useState(false);

const handleFlip = () =>{
    setFlipped(!isFlipped);
};

return (
    <div className="max-w-md mx-auto bg-white shadow-md rounded-md overflow-hidden">
        <div className={`p-6 ${isFlipped ? 'transform rotate-y-180' : ''} transition-transform duration-300`}>
            <h2 className="text-2xl front-bold mb-4">{isFlipped ? 'Answer' : 'Question'}</h2>
            <p className="text-gray-700">{isFlipped ? data.word : data.example}</p>
        </div>
        <button onClick={handleFlip}
        className="bg-blue-500 text-white py-2 px-4 mt-4 rounded-md hover:bg-blue-600 transition">
            {isFlipped ? 'Show Question' : 'Show answer'}
        </button>
    </div>
);
};

export default FlashCard;